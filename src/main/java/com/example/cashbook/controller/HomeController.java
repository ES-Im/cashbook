package com.example.cashbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cashbook.service.AdminService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class HomeController {
	@Autowired AdminService homeService;
	
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
