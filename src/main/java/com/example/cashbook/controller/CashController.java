package com.example.cashbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cashbook.service.CashService;
import com.example.cashbook.vo.cash.Cash;
import com.example.cashbook.vo.cash.CashListForm;
import com.example.cashbook.vo.member.Member;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CashController {
	@Autowired CashService cashService;
	
	@GetMapping("/member/cashListByMonth")
	public String cashListByMonth(Model model, HttpSession session, CashListForm CashListForm) {
		CashListForm.setMemberId((String) session.getAttribute("memberSession"));
		//log.debug(cashCalendar.getMemberId().toString());
		// 원하는 달의 일별 개요 출력
		List<Map<String, Object>> monthCashOutLine = cashService.getListByMonth(CashListForm);
		//log.debug(monthCashOutLine.toString());
		// 원하는 달의 달력 출력
		//log.debug(CashListForm.toString());
		
		int iterationCount = 0;
		model.addAttribute("monthCashOutLine", monthCashOutLine);
		model.addAttribute("year", CashListForm.getYear());
		model.addAttribute("month",CashListForm.getMonth());
		return "member/cashListByMonth";
	}
	
	
	@GetMapping("/member/cashListByDate")
	public String getCashListByDate(Model model, HttpSession session, CashListForm cashListForm) {
		cashListForm.setMemberId((String) session.getAttribute("memberSession"));
		
		//log.debug("getCurrentPage = " + cashListForm.getCurrentPage());
		int beginRow = (cashListForm.getCurrentPage()-1) * cashListForm.getRowPerPage();
		cashListForm.setBeginRow(beginRow);
		
		List<Cash> cashListByDate = cashService.getListByDate(cashListForm);
		log.debug("beginRow = " + cashListForm.getBeginRow());
		int lastPage = cashService.getLastPageOnDate(cashListForm);
		model.addAttribute("cashListForm", cashListForm);
		model.addAttribute("cashListByDate", cashListByDate);
		model.addAttribute("lastPage", lastPage);
		//log.debug("cashListByDate = " + cashListByDate);
		//log.debug("lastPage = " + lastPage);
		return "member/cashListByDate";
	}
}
