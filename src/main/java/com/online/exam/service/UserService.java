package com.online.exam.service;

import com.online.exam.model.Users;

public interface UserService {

	public Long save(Users users);
	public Users findById(Long userId);
}
