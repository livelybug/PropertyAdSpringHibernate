package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/SecurityLogin")
	public String showLoginForm() {
		return "SecurityLoginForm";
	}
	
	@RequestMapping("/logout")
	public String showLogoutPage() {
		return "LogoutPage";
	}
	
}
