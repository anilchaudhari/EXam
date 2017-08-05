package com.online.exam.service.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import com.online.exam.dao.UserAuthDao;
import com.online.exam.dao.UserRoleDao;
import com.online.exam.model.Role;
import com.online.exam.model.UserAccountEnabled;
import com.online.exam.model.UserAuth;

public class UserAuthenticationService implements UserDetailsService {
	
	private UserAuthDao userAuthDao;
	private UserRoleDao userRoleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}


	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	
	public UserAuthDao getUserAuthDao() {
		return userAuthDao;
	}


	public void setUserAuthDao(UserAuthDao userAuthDao) {
		this.userAuthDao = userAuthDao;
	}


	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}


	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}


	//@Override
    @Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {

		UserAuth userAuth = userAuthDao.getUserAuthDetails( username );
		System.out.println("userAuth is:"+userAuth.getUserID());
		List<GrantedAuthority> authorities = buildUserAuthority( username );

		return buildUserForAuthentication( userAuth, authorities );
	}


	// Converts com.chipmonk.ollohes.model.UserAuth user to org.springframework.security.core.userdetails.User
    //
	private User buildUserForAuthentication( UserAuth userAuth, List<GrantedAuthority> authorities ) 
    {
		System.out.println("decoded pass:"+userAuth.getUserPasswd());
		return new User( userAuth.getUserID(), 
				userAuth.getUserPasswd(), 
                userAuth.getEnabled().equals( UserAccountEnabled.TRUE ), 
                true, 
                true, 
                true, 
                authorities );
	}

    @Transactional
	private List<GrantedAuthority> buildUserAuthority(String username ) 
    {
        Role userRole = userRoleDao.getUserRoleDetails( username );
        System.out.println("User Role is:"+userRole.getRoleType());
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
        // we have only one role for now
		setAuths.add(new SimpleGrantedAuthority(userRole.getRoleType()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		 System.out.println("User GrantedAuthority:"+Result);
		return Result;
	}



}
