package com.study.springfinal.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springfinal.domain.Gallery;
import com.study.springfinal.mybatis.config.MybatisConfigManager;

//표시를 해줘야 메모리 대상이 된다@Repository
@Repository
public class GalleryDAO {
	@Autowired(required = false)
	private MybatisConfigManager manager;

	
	public int insert(Gallery gallery) {
		int result = 0;
		SqlSession sqlSession  = manager.getSqlSession();
		result = sqlSession.insert("Gallery.insert", gallery);
		sqlSession.commit();
		manager.close(sqlSession);
		return result;
	}
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list =sqlSession.selectList("Gallery.selectAll");
		manager.close(sqlSession);
		return list;
	}
	
	public Gallery select(int gallery_id) {
		Gallery gallery = null;
		SqlSession sqlSession = manager.getSqlSession();
		gallery = sqlSession.selectOne("Gallery.select" , gallery_id);
		manager.close(sqlSession);
		return gallery;
	}
	
	public int update(Gallery gallery) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result= sqlSession.update("Gallery.update", gallery);
		sqlSession.commit();
		manager.close(sqlSession);
		return result;
	}
	
	public int delete(int gallery_id) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result= sqlSession.delete("Gallery.delete", gallery_id);
		sqlSession.commit();
		manager.close(sqlSession);
		return result;
	}
}
