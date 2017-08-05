package com.online.exam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.UserAuthDao;
import com.online.exam.model.UserAuth;

@Service
@Transactional
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private UserAuthDao userAuthDao;
	public UserAuthDao getUserAuthDao() {
		return userAuthDao;
	}
	public void setUserAuthDao(UserAuthDao userAuthDao) {
		this.userAuthDao = userAuthDao;
	}
	public void save(UserAuth userAuth) {
		
		userAuthDao.save(userAuth);
	}

}
