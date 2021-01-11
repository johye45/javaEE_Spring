package com.koreait.petshop2.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop2.exception.MailSendException;
import com.koreait.petshop2.exception.MemberRegistException;
import com.koreait.petshop2.model.domain.Member;
import com.koreait.petshop2.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	
	//ȸ������ �� 
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public String getRegistForm() {
		return "/shop/member/signup";
	}
	
	//ȸ�� ���� ��
	@RequestMapping(value="/shop/member/thanksForm")
	public String getThanksForm() {
		return "/shop/member/thanks";
	}
	
	//�α��� �� (�׺����ð�� ModelAndView�� �����ؾ���)
	@GetMapping("/shop/member/loginForm")
	public ModelAndView getLoinForm() {
		
		ModelAndView mav = new ModelAndView("/shop/member/signin");
		return mav;
	}
	
	
	
	//���̵� �ߺ� �˻�
	@RequestMapping(value ="/shop/member/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPost(String user_id) throws Exception{
			//logger.debug("memberIdChk() ����");
		int result= memberService.duplicateCheck(user_id);
		//logger.debug("��� ��:"+result);
		if(result ==0 ) {
			return "success"; //�ߺ����̵� ����
		}else {
			return "fail"; //�ߺ����̵� ����
		}
	}
	
	//ȸ������ ��ûó��
	@RequestMapping(value="/shop/member/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String regist(Member member) {
		logger.debug("���̵�"+member.getUser_id());
		logger.debug("�̸�"+member.getName());
		logger.debug("��й�ȣ"+member.getPassword());
		logger.debug("�̸���"+member.getEmail_id());
		logger.debug("�̸��ϼ���"+member.getEmail_server());
		logger.debug("�����ȣ"+member.getZipcode());
		logger.debug("�ּ�"+member.getAddr());
		
		memberService.regist(member);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"ȸ������ ����\"");
		sb.append("}");
		return sb.toString();
	}
	
	//���� �ڵ鷯 ó�� (���Կ���)
	@ExceptionHandler(MemberRegistException.class)
	@ResponseBody
	public String handleException(MemberRegistException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":0, ");
		sb.append(" \"msg\":\""+e.getMessage()+"\"");
		//���� ���� ���� �߻����� ���� ȸ�������� ������� �ʰ��ֽ��ϴ�. �ִ��� ���� ���� �����ϵ��� �ϰڽ��ϴ�. �̿뿡 ������ ����� �˼��մϴ�.
		sb.append("}");
		
		return sb.toString();
	}
	
	//���� �ڵ鷯 ó�� (���� �߼� ����)
	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		//���������� �̵�
		mav.addObject("msg", e.getMessage()); //����ڰ� ���Ե� �����޽���
		mav.setViewName("shop/error/result");
		
		//�ý��� �����ڿ��� �����˸���
		return mav;
	}
}