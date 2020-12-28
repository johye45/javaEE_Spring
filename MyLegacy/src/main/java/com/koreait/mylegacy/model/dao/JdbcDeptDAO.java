package com.koreait.mylegacy.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.pool.PoolManager;

//Dept테이블에 대한 CRUD를 수행하되, jdbc기반으로 코드를 작성
@Repository //servlet-context에 올려주기 위해
public class JdbcDeptDAO {
	@Autowired
	private PoolManager poolManager;
	
	public List selectAll() {
		List list = null;
		return list;
	}
	
	public Dept select(int deptno) {
		Dept dept = null;
		return dept;
	}
	
	public int regist(Dept dept) {
		int result = 0;
		System.out.println("풀매니저"+poolManager);
		return result;
	}
	
	public int update(Dept dept) {
		int result = 0;
		return result;
	}
	
	public int delete(int deptno) {
		int result = 0;
		return result;
	}
}
