package com.koreait.mvclegacy.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;

@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	//스프링이 지원하는 DB기술을 이용하기 전에는, 트랜잭션 때문에 SqlSession을 서비스로부터
	//주입받았으나, 더이상트랜잭션 때문에 서비스에서 주입받을 필요 없다, 스프링이 알아서
	//트랜잭션을 처리해준다
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	//모든거 
	public List selectAll() {
		List list = null;
		list = sessionTemplate.selectList("Notice.selectAll");
		return list;
	}
	
	//한건 가져오기
	public Notice select(int notice_id) {
		Notice notice =null;
		notice = sessionTemplate.selectOne("Notice.select", notice_id);
		return notice;
	}
	
	public void insert(Notice notice) throws DMLException{
		int result=sessionTemplate.insert("Notice.insert", notice);
		result=0;
		if(result==0) {//수정 실패
			throw new DMLException("등록 실패!!!!!!!!!!!!!");
		}
	}
	
	public void update(Notice notice) throws DMLException{
		int result = sessionTemplate.update("Notice.update",notice);
		result=0;
		if(result==0) {//수정 실패
			throw new DMLException("수정 실패!!!!!!!!!!!!!");
		}
	}
	
	public void delete(int notice_id) throws DMLException{
		int result  =sessionTemplate.delete("Notice.delete", notice_id);
		result=0;
		if(result==0) {//수정 실패
			throw new DMLException("삭제 실패!!!!!!!!!!!!!");
		}
	}

}
