package com.simplilearn.sportyshoes.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.entity.User;
import com.simplilearn.sportyshoes.entity.UserRole;
import com.simplilearn.sportyshoes.service.SSUserDetailsService;

@Controller
public class LoginController {

	@Autowired
	private SSUserDetailsService userService;
	
	@GetMapping("/login")
	public String login() {
		System.out.println("***************inside login");
		return "login";
	}

	@GetMapping("/admin/login")
	public String adminLogin() {
		System.out.println("***************inside admin login");
		return "admin/login";
	}

	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("userForm", new User());
		return "register";
	}

	@GetMapping("/admin/register")
	public String showAdminRegisterForm(Model model) {
		model.addAttribute("userForm", new User());
		return "admin/register";
	}

	@PostMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("userForm") User userForm, BindingResult result) {
		ModelAndView mv;
		System.out.println("************* user: " + userForm );
		if (result.hasErrors()) {
			mv = new ModelAndView("register","userForm",userForm);
		}
		
		else {
			userForm.setRole(UserRole.USER);
			userService.saveUser(userForm);
			mv=new ModelAndView("redirect:/user/products");
		}

		return mv;
	}

	@PostMapping("/admin/register")
	public ModelAndView adminRegister(@Valid @ModelAttribute("userForm") User userForm, BindingResult result) {
		ModelAndView mv;
		System.out.println("************* user: " + userForm );
		if (result.hasErrors()) {
			mv = new ModelAndView("register","userForm",userForm);
		}
		
		else {
			userForm.setRole(UserRole.ADMIN);
			userService.saveUser(userForm);
			mv=new ModelAndView("redirect:/admin/products");
		}

		return mv;
	}
	
	@GetMapping("/user")
	public String welcome(HttpSession session) {
		return "redirect:/user/products";
	}

	@GetMapping("/admin")
	public String adminDashboard(Model model) {
		
		return "redirect:/admin/products";
	}

	@GetMapping("/changePassword")
	public String showChangePasswordForm(Model model) {
		model.addAttribute("userForm", new User());
		return "change-password";
	}

	@GetMapping("/admin/changePassword")
	public String showAdminChangePasswordForm(Model model) {
		model.addAttribute("userForm", new User());
		return "admin/change-password";
	}
	
	@PostMapping({"/changePassword"})
	public String changePassword(@ModelAttribute("userForm") User userForm, Model model)  {
		String view = "";
		try {
			userService.savePassword(userForm);
			model.addAttribute("changePasswordError","Password Successfully changed");
			view = "login";

		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			view = "change-password";
		}
		
		return view;
	}

	@PostMapping({"/admin/changePassword"})
	public String adminChangePassword(@ModelAttribute("userForm") User userForm, Model model)  {
		String view = "";
		try {
			userService.savePassword(userForm);
			model.addAttribute("changePasswordError","Password Successfully changed");
			view = "admin/login";

		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			view = "admin/change-password";
		}
		
		return view;
	}

}
