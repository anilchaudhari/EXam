package com.online.exam.dao;

import com.online.exam.model.Users;

public interface UserDao {

	public Long save(Users users);
	public Users findById(Long userId);
}
