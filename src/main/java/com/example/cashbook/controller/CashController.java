package com.example.cashbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cashbook.service.CashService;
import com.example.cashbook.vo.cash.CashCalendar;
import com.example.cashbook.vo.member.Member;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CashController {
	@Autowired CashService cashService;
	
	@GetMapping("/member/cashListByMonth")
	public String cashListByMonth(HttpSession session, CashCalendar cashCalendar, Model model) {
		cashCalendar.setMemberId((String) session.getAttribute("memberSession"));
		//log.debug(cashCalendar.getMemberId().toString());
		// 원하는 달의 일별 개요 출력
		List<Map<String, Object>> monthCashOutLine = cashService.getListByMonth(cashCalendar);
		//log.debug(monthCashOutLine.toString());
		// 원하는 달의 달력 출력
		log.debug(cashCalendar.toString());
		
		int iterationCount = 0;
		model.addAttribute("monthCashOutLine", monthCashOutLine);
		model.addAttribute("year", cashCalendar.getYear());
		model.addAttribute("month",cashCalendar.getMonth());
		return "member/cashListByMonth";
	}
}
