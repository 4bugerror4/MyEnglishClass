package com.bug.eng.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bug.eng.config.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	@GetMapping("/auth/user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/auth/user/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/user/info")
	public String info(@AuthenticationPrincipal PrincipalDetails principal, Model model) {
		
		model.addAttribute("principal", principal);
		
		return "user/info";
	}

}
