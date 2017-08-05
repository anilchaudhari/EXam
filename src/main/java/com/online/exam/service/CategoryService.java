package com.online.exam.service;

import java.util.List;

import com.online.exam.model.QCategory;

public interface CategoryService {

	public Long saveCategory(QCategory category);
	List<QCategory> getAllCategory();
	QCategory findById(Long cId);
	void deleteCategory(QCategory category);
}
