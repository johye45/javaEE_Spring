package com.koreait.fashionshop.controller.payment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.common.MessageData;
import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.exception.LoginRequiredException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.payment.service.PaymentService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;



//��ٱ���, �ֹ� ó�� ��Ʈ�ѷ�, �񵿱������� ó���ϱ� ���� ��Ʈ�ѷ�
@Controller
@RequestMapping(value="/async")
public class RestPaymentController {

	private static final Logger logger = LoggerFactory.getLogger(RestPaymentController.class);
	
	@Autowired
	private  PaymentService paymentService; 
	
	//��ٱ��Ͽ� ��ǰ ���
	//�񵿱�� ���
	@RequestMapping(value="/shop/cart/regist", method = RequestMethod.POST)
	@ResponseBody
	public MessageData registCart(Cart cart, HttpSession session) {
		if(session.getAttribute("member")==null) {
			//���⼭ ���ܸ� ó���ϸ� , ��� ��Ʈ�ѷ� �޼��帶�� �α��ΰ� ���õ� �ڵ尡 �ߺ��ǹǷ�.
			//���ܸ� ������ �ϳ��� �޼��忡�� ó���ϵ��� ���뼺�� ������
			throw new LoginRequiredException("�α����� �ʿ��� ���� �Դϴ�");
		}
		
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
	@ResponseBody
	public MessageData handleException(LoginRequiredException e) {
	
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());


		return messageData;
	}
	
	
}
