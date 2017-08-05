package com.online.exam.dao;

import com.online.exam.model.Role;

public interface UserRoleDao {
 
	public void save(Role role);
	public Role getUserRoleDetails( String userID );
}
