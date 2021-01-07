package com.koreait.fashionshop.controller.payment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.common.MessageData;
import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.exception.LoginRequiredException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.payment.service.PaymentService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;



//��ٱ���, �ֹ� ó�� ��Ʈ�ѷ�
@Controller
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private  PaymentService paymentService; 
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//��ٱ��Ͽ� ��ǰ ���
	//�񵿱�� ���
	@RequestMapping(value="/shop/cart/regist", method = RequestMethod.POST)
	@ResponseBody
	public MessageData registCart(Cart cart, HttpSession session) {
		
		Member member =(Member)session.getAttribute("member");
		logger.debug("��ǰ"+cart.getProduct_id());
		logger.debug("����"+cart.getQuantity());
		cart.setMember_id(member.getMember_id());
		paymentService.insert(cart);
		
		//MessageConverter�� ���� VO�� JSON���·� ����Ǿ��� �� �ִ�
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);//������ ������ �� ����
		messageData.setMsg("��ٱ��Ͽ� ��ǰ�� �����ϴ�.");
		messageData.setUrl("/shop/cart/list");
		return messageData;
	}
	
	//��ٱ��� ��� ��û 
	@RequestMapping(value="/shop/cart/list" , method=RequestMethod.GET)
	public ModelAndView getCartList(HttpSession session) {
		//��ٱ��� ��� ��û���� �ռ�, �켱 ����ó������ ���� �ؾ���
		if(session.getAttribute("member")==null) {
			//���⼭ ���ܸ� ó���ϸ� , ��� ��Ʈ�ѷ� �޼��帶�� �α��ΰ� ���õ� �ڵ尡 �ߺ��ǹǷ�.
			//���ܸ� ������ �ϳ��� �޼��忡�� ó���ϵ��� ���뼺�� ������
			throw new LoginRequiredException("�α����� �ʿ��� ���� �Դϴ�");
		}
		
		Member member =(Member)session.getAttribute("member");
		List topList = topCategoryService.selectAll();
		List cartList = paymentService.selectCartList(member.getMember_id());//ȸ���� ���̵�
		
		ModelAndView mav  = new ModelAndView("shop/cart/cart_list");
		mav.addObject("topList", topList);
		mav.addObject("cartList", cartList);
		
		return mav;
	}
	
	//��ٱ��� ����
	@RequestMapping(value="/shop/cart/del", method=RequestMethod.GET)
	public String delCart(HttpSession session) {

		//��ٱ��ϸ� �����ϱ� ���ؼ��� �α����� ȸ���� ����
		if(session.getAttribute("member")==null) {
			throw  new LoginRequiredException("�α��� �ʿ��� �����Դϴ�");
		}
		paymentService.delete((Member)session.getAttribute("member"));
		
		return "redirect:/shop/cart/list";
	}
	
	//��ٱ��� �����ϱ�
	@RequestMapping(value="/shop/cart/edit", method=RequestMethod.POST)
	public ModelAndView editCart(@RequestParam("cart_id") int[] cartArray,@RequestParam("quantity") int[] qArray ) {
		
		//�Ѱܹ��� �Ķ���� ����ϱ� cart_id, quantity(cart_list���� �ݺ������� ���� name=quantity�� �迭�� �Ѿ�´� )
		logger.debug("cartArray length "+cartArray.length);

		List cartList = new ArrayList();
		for(int i=0; i<cartArray.length;i++) {
			Cart cart = new Cart();
			cart.setCart_id(cartArray[i]);
			cart.setQuantity(qArray[i]);
			cartList.add(cart);
		}
		paymentService.update(cartList);
		
		//�����Ǿ��ٴ� �޽����� ����͵��� message.jsp������������
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("�����Ǿ����ϴ�");
		messageData.setUrl("/shop/cart/list");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(messageData);
		mav.setViewName("shop/error/message");
		
		return  mav;
	}

	//��ٱ��� ����ó��
	@ExceptionHandler(CartException.class)
	@ResponseBody
	public MessageData hadelException(CartException e) {
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);//������ ������ �� ����
		messageData.setMsg(e.getMessage());

		return messageData;
	}
	
	//�α������� �ʾ�����
	@ExceptionHandler(LoginRequiredException.class)
	public ModelAndView handleException(LoginRequiredException e) {
		ModelAndView mav = new ModelAndView();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());

		mav.addObject("messageData", messageData);
		mav.setViewName("shop/error/message");
		return mav;
	}
	
	
}
