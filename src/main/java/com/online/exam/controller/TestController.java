package com.online.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.exam.model.Users;

@Controller
public class TestController {
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public String testdemo(){
		
		return "admin";
	}
	@RequestMapping(value="faculty",method=RequestMethod.GET)
	public String facultyTest(){
		
		return "faculty";
	}
	@RequestMapping(value="student",method=RequestMethod.GET)
	public String studentTest(){
		
		return "student";
	}
	@RequestMapping(value="profile",method=RequestMethod.GET)
	public String profile(){
		
		return "Aprofile";
	}
	
	//New User
	@RequestMapping(value="registration",method=RequestMethod.GET)
	public String updateOrAddUser(Model model){
		model.addAttribute("user", new Users());
		return "registration";
	}
	
	
	/*//Questions List
	@RequestMapping(value="question",method=RequestMethod.GET)
	public String addOrUpdateQuestion(){
		
		return "new_question";
	}*/
		//login Test
		@RequestMapping(value="login",method=RequestMethod.GET)
		public String login(){
			
			return "login";
		}
}
