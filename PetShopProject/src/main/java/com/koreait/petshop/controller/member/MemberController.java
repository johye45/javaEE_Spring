package com.koreait.petshop.controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.exception.MemberDeleteException;
import com.koreait.petshop.exception.MemberEditException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.common.MailSender;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MailSender mailSender;

/****************************************************************************
 	Shop���� ����
 *****************************************************************************/
	//ȸ������ �� 
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public String getRegistForm() {
		return "/shop/member/signup";
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
	public String regist(Member member){
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
	
	//ȸ�� ���� ��
	@RequestMapping(value="/shop/member/thanksForm")
	public String getThanksForm() {
		return "/shop/member/thanks";
	}
	
	//�α��� �� (�׺����ð�� ModelAndView�� �����ؾ���)
	@GetMapping("/shop/member/loginForm")
	public ModelAndView getLoginForm() {
		//topList ��û
		ModelAndView mav = new ModelAndView("/shop/member/signin");
		return mav;
	}
	
	//�α��� ��û ó��
	@PostMapping(value="/shop/member/login")
	public String login(Member member,HttpServletRequest request) {
		
		//db���翩��Ȯ��
		Member obj = memberService.select(member);
		//���ǿ� ȸ������ ��Ƶα�
		HttpSession session=request.getSession();
		session.setAttribute("member", obj); //���� Ŭ���̾�Ʈ ��û�� ����� ���ǿ� ����
		return "redirect:/";
	}
	
	// ����ã�� ������ ��ûó��
	@GetMapping("/shop/member/forgot")
	public String forgot() {
		return "/shop/member/forgot";
	}

	// ȸ�����̵�ã��
	@RequestMapping(value = "/shop/member/forgot_id", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public  String forgot_id(@ModelAttribute Member member, Model model, HttpServletResponse response) throws MemberNotFoundException {
		System.out.println(member.toString());

		ArrayList<String> idList = memberService.forgot_id(member);
		System.out.println(idList.toString());
		System.out.println(idList.get(0));
		String user_id = "{\"user_id\":\"" + idList + "\"}";
		System.out.println(user_id);
		return user_id;
	}
	
	//ȸ�� ��й�ȣ ã��
	@RequestMapping(value ="/shop/member/forgot_pwd", method = RequestMethod.POST)
	@ResponseBody
	public MessageData forgot_pwd(Member member) {
		memberService.forgot_pwd(member);
		
		System.out.println("controller���� ���� member"+member);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("����Ͻ� ���Ϸ� �ӽ� ��й�ȣ�� �߱޵Ǿ����ϴ�.");
		messageData.setUrl("/shop/member/loginForm");
		
		return messageData;
	}

	//�α׾ƿ� ��û ó��
	@GetMapping(value="/shop/member/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate(); //���� ��ȿȭ. ���� ȿ�»��
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("�α׾ƿ� �Ǿ����ϴ�");
		messageData.setUrl("/");
		
		ModelAndView mav = new ModelAndView("/shop/error/message");
		mav.addObject("messageData", messageData);
		
		return mav;
	}
	
	//���������� order(�⺻��) ��ûó��
	@GetMapping("/shop/member/mypage_order")
	public String mypageOrder() {
		return "/shop/member/mypage_order";
	}
	
	//���������� �������� ��ûó�� (ȸ�� ������ ��ȸ)
	@GetMapping("/shop/member/mypage_profile")
	public ModelAndView select(HttpSession session) {
		
		Member member = (Member)session.getAttribute("member");
		String user_id = member.getUser_id();
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.setViewName("/shop/member/mypage_profile");
		return mav;
	}
	
	//ȸ������ ����
	@PostMapping(value="/shop/member/memberUpdate")
	@ResponseBody
	public MessageData update(Member member, HttpSession session) throws MemberEditException{
		logger.debug("���̵�"+member.getUser_id());
		logger.debug("�̸�"+member.getName());
		logger.debug("��й�ȣ"+member.getPassword());
		logger.debug("�̸���"+member.getEmail_id());
		logger.debug("�̸��ϼ���"+member.getEmail_server());
		logger.debug("�����ȣ"+member.getZipcode());
		logger.debug("�ּ�"+member.getAddr());
		
		memberService.update(member);
		session.setAttribute("member", member);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("ȸ�������� �����Ǿ����ϴ�.");
		messageData.setUrl("/shop/member/mypage_profile");
		
		return messageData;
	}
	
	//���������� ȸ��Ż�������� ��û
		@GetMapping("/shop/member/mypage_delete")
		public ModelAndView mypage_delete(HttpSession session) {
			
			Member member = (Member)session.getAttribute("member");
			String user_id = member.getUser_id();
			String password = member.getPassword();
			ModelAndView mav = new ModelAndView();
			mav.addObject("user_id", user_id);
			mav.addObject("password", password);
			mav.setViewName("/shop/member/mypage_delete");
			return mav;
		}
	
	//ȸ�� Ż��
	@PostMapping("/shop/member/delete")
	@ResponseBody
	public ModelAndView delete(Member member, HttpSession session) throws MemberDeleteException{
		memberService.delete(member);
		
		session.invalidate();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
		messageData.setUrl("/");
		
		ModelAndView mav = new ModelAndView("/shop/error/message");
		mav.addObject("messageData", messageData);
		
		return mav;
	}
	
/****************************************************************************
 	Admin ���� ����
 *****************************************************************************/	
	//ȸ�� ��� ����Ʈ
	@GetMapping("/admin/member/list")
	public ModelAndView getMemberList() {
		ModelAndView mav = new ModelAndView("admin/member/member_list");
	
		List memberList = memberService.selectAll();
		mav.addObject("memberList",memberList);
		
		logger.debug("memberList.size()"+memberList.size());
		
		return mav;
	}
	
/****************************************************************************
 	�����ڵ鷯 ó��
 *****************************************************************************/
		
	//���Կ���
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
	
	//���� �߼� ����
	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		//���������� �̵�
		mav.addObject("msg", e.getMessage()); //����ڰ� ���Ե� �����޽���
		mav.setViewName("shop/error/result");
		
		//�ý��� �����ڿ��� �����˸���
		return mav;
	}
	
	//�α��� ����
	@ExceptionHandler(MemberNotFoundException.class)
	public ModelAndView handleException(MemberNotFoundException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage());
		mav.setViewName("shop/error/result");
	
		return mav;
	}
	
	
	//ȸ���������� ����
	@ExceptionHandler(MemberEditException.class)
	public ModelAndView handleException(MemberEditException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage());
		mav.setViewName("shop/error/result");
	
		return mav;
	}
	
	//ȸ��Ż�� ����
	@ExceptionHandler(MemberDeleteException.class)
	public ModelAndView handleException(MemberDeleteException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage());
		mav.setViewName("shop/error/result");
		
		return mav;
	}
}