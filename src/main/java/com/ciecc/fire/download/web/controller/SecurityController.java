package com.ciecc.fire.download.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("login-error")
	public String loginError(Model model) {
		return "login";
	}
	
	@GetMapping("signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("signup")
	public String signup(String username, String passwprd, String nickname, Model model) {
		
		model.addAttribute("message", "注册成功");
		return "signup-success";
	}

}
