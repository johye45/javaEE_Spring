package com.koreait.fashionshop.controller.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.payment.service.PaymentService;



//장바구니, 주문 처리 컨트롤러
@Controller
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	private  PaymentService paymentService; 
	
	//장바구니에 상품 담기
	//비동기로 담기
	@RequestMapping(value="/shop/cart/regist", method = RequestMethod.POST)
	public String registCart(Cart cart) {
		logger.debug("상품"+cart.getProduct_id());
		logger.debug("수량"+cart.getQuantity());
		
		cart.setMember_id(1);
		paymentService.insert(cart);
		

		return null;
	}

}
