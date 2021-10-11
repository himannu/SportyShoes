package com.simplilearn.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.service.SSUserDetailsService;

@Controller
public class UserController {

	@Autowired
	private SSUserDetailsService userService;
	
	@GetMapping("/admin/users")
	public ModelAndView getUsers() {
		
		return new ModelAndView("users/list-users","users", userService.getUsers());
		
	}
	
	@PostMapping("/admin/searchUser")
	public ModelAndView getUsersByUserName(@RequestParam("uname")String uname, @RequestParam("email") String email) {
		return new ModelAndView("users/list-users","users", userService.getUserByCriteria(uname,email));
	}
}
