package com.online.exam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.CategoryDao;
import com.online.exam.model.QCategory;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Long saveCategory(QCategory category) {
		
		return categoryDao.saveCategory(category);
	}

	public List<QCategory> getAllCategory() {
		
		return categoryDao.getAllCategory();
	}

	public QCategory findById(Long cId) {
		
		return categoryDao.findById(cId);
	}

	public void deleteCategory(QCategory category) {
		categoryDao.deleteCategory(category);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	

}
