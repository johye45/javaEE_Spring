package com.koreait.petshop.controller.payment;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.exception.LoginRequiredException;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.domain.OrderDetail;
import com.koreait.petshop.model.domain.OrderSummary;
import com.koreait.petshop.model.domain.Product;
import com.koreait.petshop.model.domain.Receiver;
import com.koreait.petshop.model.domain.SubCategory;
import com.koreait.petshop.model.payment.service.PaymentService;
import com.koreait.petshop.model.product.service.TopCategoryService;

import sun.java2d.opengl.WGLSurfaceData.WGLVSyncOffScreenSurfaceData;
import sun.print.resources.serviceui;

@Controller
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private TopCategoryService topCategoryService;

	// ��ٱ��� ��� ��û
	@RequestMapping(value = "/shop/cart/list", method = RequestMethod.GET)
	public ModelAndView getCartList(HttpServletRequest request) {
		System.out.println("hi");
		logger.debug(">>>getCartList");
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		System.out.println("member" + member.getMember_id());
		List topList = topCategoryService.selectAll();
		List cartList = paymentService.selectCartList(member.getMember_id());
		ModelAndView mav = new ModelAndView("shop/cart/cart_list");
		mav.addObject("topList", topList);
		mav.addObject("cartList", cartList);
		return mav;
	}

	// ��ٱ��Ͽ� ��ǰ ��� ��û
	@RequestMapping(value = "/shop/cart/regist", method = RequestMethod.POST)
	@ResponseBody
	public MessageData  registCart(Cart cart, HttpSession session) {
		logger.debug("��ٱ��� ���");
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�.");
		}
		Member member = (Member) session.getAttribute("member");
		logger.debug("product_id " + cart.getProduct_id());
		logger.debug("quantity " + cart.getQuantity());
		cart.setMember_id(member.getMember_id());
		paymentService.insert(cart);
		logger.debug("finished cart regist !!!");
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("��ٱ��Ͽ� ��ǰ�� �����ϴ�");
		messageData.setUrl("/shop/cart/list");
		return messageData;
	}
	
	// ��ٱ��� ���� �ϳ� ���� 
	@RequestMapping(value = "/shop/cart/Onedel", method = RequestMethod.GET)
	public String delOne(HttpSession session,Cart cart) {
		// ��ٱ��ϸ� �����ϱ� ���ؼ���, �α����� ȸ���� ����..
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException("�α��� ���� ���ּ���");
		}
		logger.debug("īƮ id��?", cart.getCart_id());
		paymentService.delete(cart); //īƮ ���̵� ����ؼ� 1�� delete
		return "redirect:/shop/cart/list";
	}

	// ��ٱ��� ��ü ����
	@RequestMapping(value = "/shop/cart/del", method = RequestMethod.GET)
	public String delCart(HttpSession session) {
		// ��ٱ��ϸ� �����ϱ� ���ؼ���, �α����� ȸ���� ����..
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException("�α��� ���� ���ּ���");
		}
		paymentService.delete((Member) session.getAttribute("member"));
		return "redirect:/shop/cart/list";
	}

	// ��ٱ��� ����
	@RequestMapping(value = "/shop/cart/edit", method = RequestMethod.POST)
	public ModelAndView editCart(@RequestParam("cart_id") int[] cartArray, @RequestParam("quantity") int[] qArray) {
		// �Ѱܹ��� cart_id, quantity �Ķ���� ���
		logger.debug("cartArray length " + cartArray.length);		
		List cartList = new ArrayList();
		for (int i = 0; i < cartArray.length; i++) {
			Cart cart = new Cart();
			cart.setCart_id(cartArray[i]);
			cart.setQuantity(qArray[i]);
			cartList.add(cart);
		}
		paymentService.update(cartList);
		// �����Ǿ�����
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("��ٱ��ϰ� �����Ǿ����ϴ�");
		messageData.setUrl("/shop/cart/list");
		// �ƴϸ� �����޼���
		ModelAndView mav = new ModelAndView();
		mav.addObject("messageData", messageData);
		mav.setViewName("shop/error/message");
		return mav;
	}
	
	
/*
	// ����������
	@RequestMapping(value = "/shop/payment/form", method = RequestMethod.GET)
	public ModelAndView payForm() {
		ModelAndView mav = new ModelAndView();
		List topList = topCategoryService.selectAll();
		mav.addObject("topList", topList);
		mav.setViewName("shop/payment/checkout");
		return mav;
	}
*/	


	// üũ�ƿ� ������ ��û
	@GetMapping("/shop/payment/form")
	public String payForm(Model model, HttpSession session) {
		List topList = topCategoryService.selectAll();
		model.addAttribute("topList", topList); // ModelAndView������ Model�� ���..

		// �������� ��������
		List paymethodList = paymentService.selectPaymethodList();
		model.addAttribute("paymethodList", paymethodList);

		// ��ٱ��� ������ ��������
		Member member = (Member) session.getAttribute("member");
		List cartList = paymentService.selectCartList(member.getMember_id());
		model.addAttribute("cartList", cartList);
		
		return "shop/payment/checkout";
	}


	// ����Ȯ��������
	@PostMapping("/shop/payment/confirm")
	public String pay(HttpSession session, OrderSummary orderSummary, Receiver receiver,OrderDetail orderDetail,Product product) {
		
		logger.debug("��ǰ�̸�" + product.getProduct_name());
		logger.debug("��ǰ���� " + product.getPrice());
		logger.debug("���Ű��� " + orderDetail.getQuantity());
		logger.debug("���� ��� �̸� " + receiver.getReceiver_name());
		logger.debug("���� ��� ����ó " + receiver.getReceiver_phone());
		logger.debug("���� ��� �ּ� " + receiver.getReceiver_addr());
		logger.debug("��������� " + orderSummary.getPaymethod_id());
		logger.debug("total_price " + orderSummary.getTotal_price());
		logger.debug("total_pay " + orderSummary.getTotal_price());
	
		
		Member member = (Member) session.getAttribute("member");
		orderSummary.setMember_id(member.getMember_id()); //  regist������ �� ���� �Ű������� ���� ���°ǰ���.. �ʿ��� �κ��ε� , �̰� �����ð��� �ϴٰ� ������ ...���� �������� ��
		//�¾ƿ�, ��Ʈ�ѷ��� ����� ������ �ۼ��ϸ� �ȵǱ� ������, Ŭ���̾�Ʈ�� �Ѱ��� �Ķ���͸� ���񽺿��� �Ѱܾ� �ϰ�, 
		//�ֹ��Ҷ��� ���� �� �Ķ���Ͱ� ���� ���̿���, ���� ���ٰ� �ؼ� ��Ȳ�� �ʿ� ���� .�� �Ѱ��� ,, �̰� «�ͽ��Ѽ� �����;��Ѵٴ°�,, �׳� �߸𸣰Լ���;;�����ϳ׿�
		//�ٵ� �ظ��ϸ�, ���� ���԰��迡 ������ �� Ư��VO�� Ư�� ���̿��� �����Ҷ��� ������ ����� �ʿ�� ����, ���� ��� 
		//OrderSummary�� ������ VO�� �ִٸ� ���� �� ����� �ʿ�� ���°��� �չ� ������� 
		//�Ű������߿��� SubCategory subCategory �� �̹� Product product �� �����ϰ� �������� ������ �Ѵ� ���ʿ�� ���°� �̱��� ~�����ϼ��� ?�� 
		//�״�� Ŭ���̾�Ʈ�� �Ű����� �����Ҷ� �������� ��ǰ �ȿ� ����ִ� subCategory�� �������� �ؿ� , ���� ? �� �����ֹ� ������ ������� �ֹ� ��û ������ �̰� ���� �������� �̹����θ� ��ĸ���ߴµ� ..
		//�׷� ���� ��� ������, subCategory ���� �̹� Product�� ������ִ� ���̿��� �̿��ؾ� �ϹǷ�, 
		//���̿����ǿ��� �������Ҷ� �̷��� �ؾ� �ſ� , subCateogry.subcategory_id (product vo �ȿ� ����ֱ� ������ )  �̿����� ?�� , �׷� �׷��� �������ּ��� �� �� �׸��� �Ʊ� �� ���� ����� ���� �ٲ�°� ���������� �غôµ� �ѹ� ���ֽǼ� �ֳ���..
		paymentService.registOrder(orderSummary, receiver,orderDetail,product);
		
		return "/shop/payment/confirm_message";
		
	}


	
	
	/*
	//�����Ϸ�â
	@RequestMapping(value="/shop/payment/confirm")
	public String getConfirm() {
		return "/shop/payment/confirm_message";
	}
*/
	
	
	// ��ٱ��Ͽ� ���õ� ����ó�� �ڵ鷯
	@ExceptionHandler(CartException.class)
	@ResponseBody
	public MessageData handleException(CartException e) {
		logger.debug("�ڵ鷯 ������ " + e.getMessage());
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		return messageData;
	}

}
