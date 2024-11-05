package com.example.cashbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cashbook.mapper.AdminMapper;
import com.example.cashbook.mapper.MemberMapper;
import com.example.cashbook.service.LoginService;
import com.example.cashbook.vo.Admin;
import com.example.cashbook.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	@Autowired LoginService loginService;
	
	
	// Member Session ----------------------------------------------------------------------------------------------
	@GetMapping("/off/memberLogin")
	public String memberLogin() {
		
		return "off/memberLogin";
	}
	
	@PostMapping("/off/memberLogin")
	public String memberLogin(HttpSession session, Model model, @RequestParam() String id, @RequestParam() String pw) {
		Member paramMember = new Member();
		paramMember.setMemberId(id);
		paramMember.setMemberPw(pw);
		
		Member member = loginService.login(paramMember);
		
		if(member == null) {
			log.debug("member Login failed");
			model.addAttribute("msg", "Login failed, check id or pw");
			return "off/memberLogin";
		}
		session.setAttribute("memberId", member);
		log.debug("Login success");
		return "redirect:/member/home";
	}
	
	// Admin Session ----------------------------------------------------------------------------------------------
	@GetMapping("/off/adminLogin")
	public String adminLogin() {
		
		return "off/adminLogin";
	}
	
	@PostMapping("/off/adminLogin")
	public String adminLogin(HttpSession session, Model model, HttpServletRequest request, @RequestParam() String id, @RequestParam() String pw) {
		Admin paramAdmin = new Admin();
		paramAdmin.setAdminId(id);
		paramAdmin.setAdminPw(pw);
		
		Admin admin = loginService.login(paramAdmin);
		
		if(admin == null) {
			log.debug("admin Login failed");
			request.setAttribute("msg", "Login failed, check id or pw");
			return "off/adminLogin";
		}
		session.setAttribute("adminId", admin);
		log.debug("Login success");
		return "redirect:/admin/home";
	}
	
	//Logout -----------------------------------------------------------------------------------------------------------
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/off/home";
	}
}
