package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;
import com.model2.domain.Board;

public class DetailController implements Controller{
//상세보기 
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계
		String board_id = request.getParameter("board_id");
		Board board= boardDAO.select(Integer.parseInt(board_id));
		
		//4단계 :저장
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board",board);

		//상세보기는 유지 포워딩
		return mav;
	}

}
