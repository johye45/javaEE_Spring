package com.koreait.petshop2.model.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.koreait.petshop2.model.domain.SubCategory;
import com.koreait.petshop2.model.product.repository.SubCategoryDAO;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryDAO subCategoryDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllById(int topcategory_id) {
		
		return subCategoryDAO.selectById(topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int SubCategory_id) {
		// TODO Auto-generated method stub
		
	}

}
