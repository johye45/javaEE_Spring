package com.koreait.mylegacy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;

//Dept테이블에 대한 CRUD를 수행하되, jdbc기반으로 코드를 작성
@Repository //servlet-context에 올려주기 위해
public class JdbcDeptDAO {
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	public List selectAll() {
		List list = null;
		return list;
	}
	
	public Dept select(int deptno) {
		Dept dept = null;
		return dept;
	}
	
	public int regist(Dept dept) throws SQLException{//예외 전가
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			result = pstmt.executeUpdate();
			
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

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
