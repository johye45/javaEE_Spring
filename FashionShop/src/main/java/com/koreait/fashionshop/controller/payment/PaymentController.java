package com.koreait.fashionshop.controller.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.payment.service.PaymentService;



//��ٱ���, �ֹ� ó�� ��Ʈ�ѷ�
@Controller
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	private  PaymentService paymentService; 
	
	//��ٱ��Ͽ� ��ǰ ���
	//�񵿱�� ���
	@RequestMapping(value="/shop/cart/regist", method = RequestMethod.POST)
	public String registCart(Cart cart) {
		logger.debug("��ǰ"+cart.getProduct_id());
		logger.debug("����"+cart.getQuantity());
		
		cart.setMember_id(1);
		paymentService.insert(cart);
		

		return null;
	}

}
