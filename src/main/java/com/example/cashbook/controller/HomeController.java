package com.example.cashbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {
	@GetMapping("/off/home")
	public String noSessionHome() {
		return "off/home";
	}
	
	@GetMapping("/admin/home")
	public String adminHome() {
		return "admin/home";
	}
	
	@GetMapping("/member/home")
	public String memberHome() {
		return "member/home";
	}
	
}
