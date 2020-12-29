package com.koreait.mylegacy.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.mylegacy.model.dao.MybatisDeptDAO;
import com.koreait.mylegacy.model.dao.MybatisEmpDAO;
import com.koreait.mylegacy.model.domain.Emp;
import com.koreait.mylegacy.mybatis.config.MybatisConfigManager;

@Service
public class MybatisEmpService {
	@Autowired
	private MybatisConfigManager manager; 
	
	@Autowired
	private MybatisEmpDAO mybatisEmpDAO;
	
	@Autowired
	private MybatisDeptDAO mybatisDeptDAO;

	//모든 레코드 가져오기
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		mybatisEmpDAO.setSqlSession(sqlSession);
		list=	mybatisEmpDAO.selectAll();
		manager.close(sqlSession);
		return list;
	}
	
	//사원 등록(부서+사원)
	public int regist(Emp emp) {
		int result =0;
		//일 시키기 전에 SqlSession배분
		SqlSession sqlSession = manager.getSqlSession();//default false
		
		mybatisEmpDAO.setSqlSession(null);
		mybatisDeptDAO.setSqlSession(null);
		
		//아래의 두 DML메서드를 대상으로 커밋해야할 코드 라인은?
		mybatisEmpDAO.regist(emp);
		mybatisDeptDAO.regist(emp.getDept());
		
		manager.close(sqlSession);
		return result;
		
	}

}
