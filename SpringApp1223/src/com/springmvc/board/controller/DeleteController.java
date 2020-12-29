package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class DeleteController implements Controller{
	//�����ϱ�
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int result =boardDAO.delete(board_id);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("result",result);
		
		if(result==1) {
			mav.setViewName("redirect:/board/list");//������ ��� ������,board/list�� ����			
		}else {
			mav.addObject("msg","���� ����");
			mav.setViewName("error/result");//������ ��� ������			
		}
	
		
		return mav;
	}
	
	

}