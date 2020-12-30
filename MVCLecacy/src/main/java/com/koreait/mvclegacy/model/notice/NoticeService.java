package com.koreait.mvclegacy.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;

@Service
public class NoticeService {
	//주입시키려 하는 자료형이 2개 이상일 경우, 개발자는 무엇을 사용할지 원하는 객체를 명시해야 한다
	@Autowired//주입
	//소문자로 시작하는 클래스를 적어주면 알아서 구분해준다,이 부분만 mybatisNoticeDAO로바꾸면 된다!
	@Qualifier("mybatisNoticeDAO")
	/*
	 * @Autowired는 타입을 이용해서 자동적으로 값을 설정한다. 
		해당 타입의 빈이 존재하지 않거나, 2개이상 존재할 경우 빈객체를 생성할 때 예외를 발생시킨다
		이러한 점을 보완하기 위한 것이 @Qualifier
		여러개의 같은 타입의 빈들 중에 주입할 특정 빈을 지정한다
	 * */
	private NoticeDAO noticeDAO;//DI로 주입받기 위해서 상위 객체를 보유한다
	
	//CRUD method
	public List selectAll() {
		List list = noticeDAO.selectAll();
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice =noticeDAO.select(notice_id);
		return notice;
	}
	
	public void insert(Notice notice) throws DMLException{
		noticeDAO.insert(notice);
	}
	
	public void update(Notice notice) throws DMLException{
		noticeDAO.update(notice);
	}
	
	public void delete(int notice_id) throws DMLException{
		noticeDAO.delete(notice_id);
	}
	
	
}
