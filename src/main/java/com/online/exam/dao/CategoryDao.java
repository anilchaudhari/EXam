package com.online.exam.dao;

import java.util.List;

import com.online.exam.model.QCategory;

public interface CategoryDao {

	public Long saveCategory(QCategory category);
	List<QCategory> getAllCategory();
	QCategory findById(Long cId);
	void deleteCategory(QCategory category);
}
