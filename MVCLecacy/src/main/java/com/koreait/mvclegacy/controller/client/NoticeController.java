package com.koreait.mvclegacy.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;
import com.koreait.mvclegacy.model.notice.NoticeService;

@Controller
public class NoticeController {
	private  static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;

	//�۾��� �� ��û ó��
	@RequestMapping("/notice/registform")
	public String getRegistForm() {
		return "notice/regist_form";
	}
	
	//�� ��� ��û ó��
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public String regist(Notice notice ) {//������������ vo�� ��������� html�� �Ķ���͸��� ������
		//�ڵ����� �����Ͱ��� ä������
		noticeService.insert(notice);//���⼭ ���ܰ� �߻��ϸ�, ����δ� ���Ʒ��� ����� ���� �ڵ鷯 �޼��� ȣ��
		return "redirect:/client/notice/list";
	}
	
	//���� ��������
	//localhost:7777/client/notice/list�� �����ؾ� ��
	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public ModelAndView selectAll() {
		logger.debug("�� ��� �޼��� ȣ��");
		ModelAndView mav = new ModelAndView();
		List noticeList =noticeService.selectAll();
		mav.addObject("noticeList",noticeList);
		mav.setViewName("notice/list");
		return mav;
	}
	
	//�Ѱǰ�������
	@RequestMapping(value = "/notice/detail", method=RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		Notice notice = noticeService.select(notice_id);
		ModelAndView mav = new ModelAndView("notice/detail");
		mav.addObject("notice",notice);
	
		return mav;
	}
	
	//�Ѱ� �����ϱ�
	@RequestMapping(value = "/notice/edit", method=RequestMethod.POST)
	public ModelAndView edit(Notice notice) {
		ModelAndView mav = new ModelAndView();
		try {
			noticeService.update(notice);
			//mav.addObject("msg","���� ����")
			mav.setViewName("redirect:/client/notice/detail?notice_id="+notice.getNotice_id());
			
		} catch (DMLException e) {
			mav.addObject("msg",e.getMessage());
			mav.setViewName("message/result");
			e.printStackTrace();
		}
		return mav;
	}

	
	//�Ѱ� �����ϱ�
	@RequestMapping(value = "/notice/del", method=RequestMethod.POST)
	public String edit(int notice_id) {
		noticeService.delete(notice_id);
		return "redirect:/client/notice/list";
	}


	//�������� ��Ʈ�ѷ��� ��û ó�� �޼��� �� ��� �ϳ��� ���ܰ� �߻��ϸ�, �� ���ܸ� ó���� �� �ִ�
	//������ �޼��尡 �����ȴ�
	//������ �޼��尡 �����ȴ�, ������̼ǿ� ����� ���ܸ� �����Ͽ� ó��
	@ExceptionHandler(DMLException.class)//������ �����ϴ� �̺�Ʈ �ڵ鷯
	public ModelAndView handleException(DMLException e) {//���� ������ �Ű�������
		ModelAndView mav = new ModelAndView();
		
		//� ������ ������? ���� �޽����� ����
		mav.addObject("msg", e.getMessage());//�� �޼��帶�� �޽����� �ٸ��⶧���� 
		
		//��� �������� ��������? message/result.jsp
		mav.setViewName("/message/result");
		return mav;
	}
}
