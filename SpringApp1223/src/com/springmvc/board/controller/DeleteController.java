package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class DeleteController implements Controller{
	//삭제하기
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
			mav.setViewName("redirect:/board/list");//성공한 경우 페이지,board/list로 재접			
		}else {
			mav.addObject("msg","삭제 실패");
			mav.setViewName("error/result");//실패한 경우 페이지			
		}
	
		
		return mav;
	}
	
	

}
