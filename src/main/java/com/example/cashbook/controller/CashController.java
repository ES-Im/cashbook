package com.example.cashbook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cashbook.service.CashService;
import com.example.cashbook.vo.CashCalendar;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CashController {
	@Autowired CashService cashService;
	
	@GetMapping("/member/cashListByMonth")
	public String cashListByMonth(HttpSession session, CashCalendar cashCalendar, Model model) {
		cashCalendar.setMemberId((String)(session.getAttribute("memberId")));
		// 원하는 달의 일별 개요 출력
		Map<String, Object> dayOutline = cashService.getListByMonth(cashCalendar);
		// 원하는 달의 달력 출력
		Map<String, Integer> target = cashService.getCalendar(cashCalendar);
		
		model.addAttribute("target", target);
		model.addAttribute("dayOutline", dayOutline);
				
		return "member/cashListByMonth";
	}
}
