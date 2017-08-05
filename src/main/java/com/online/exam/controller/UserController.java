package com.online.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.online.exam.model.Role;
import com.online.exam.model.UserAccountEnabled;
import com.online.exam.model.UserAuth;
import com.online.exam.model.Users;
import com.online.exam.service.UserAuthService;
import com.online.exam.service.UserRoleService;
import com.online.exam.service.UserService;

@Controller
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}


	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthService userAuthService;

	@Autowired
	private UserRoleService userRoleService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserAuthService getUserAuthService() {
		return userAuthService;
	}

	public void setUserAuthService(UserAuthService userAuthService) {
		this.userAuthService = userAuthService;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users users,BindingResult result){
		System.out.println("Encoded pass:"+users.getPassword());
		String encodedPass =passwordEncoder.encode(users.getPassword());
		System.out.println("Encoded pass:"+encodedPass);
		users.setPassword(encodedPass);
		UserAuth userAuth=new UserAuth();
		userAuth.setEnabled(UserAccountEnabled.TRUE);
		userAuth.setUserID(users.getUserID());
		userAuth.setUserPasswd(encodedPass);
		userAuthService.save(userAuth);
		
		Long userId = userService.save(users);
		
		Role role=new Role();
		role.setRoleType(users.getRole());
		role.setUsers(userService.findById(userId));
		role.setUserId(users.getUserID());
		userRoleService.save(role);
		return "users";
	}
	/*Displaying List of users*/
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String userdetails(){
		
		return "users";
	}
}
