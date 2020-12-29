package com.koreait.mylegacy.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;

@Repository
public class MybatisDeptDAO {

	private SqlSession sqlSession = null;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	//한건 등록
	public int regist(Dept dept) {
		int result = 0;
		result=sqlSession.insert("Dept.insert",dept);
		return result;
	}
}
