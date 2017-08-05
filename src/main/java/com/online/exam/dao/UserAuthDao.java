package com.online.exam.dao;

import com.online.exam.model.UserAuth;

public interface UserAuthDao {

	public void save(UserAuth userAuth);
	 public UserAuth getUserAuthDetails( String userID );
}
