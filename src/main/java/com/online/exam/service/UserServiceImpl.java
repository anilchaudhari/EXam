package com.online.exam.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online.exam.dao.UserDao;
import com.online.exam.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public Long save(Users users) {
		
		return userDao.save(users);
	}
	
	public Users findById(Long userId) {
		
		return userDao.findById(userId);
	}

}
