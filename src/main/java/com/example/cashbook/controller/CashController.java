package com.example.cashbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cashbook.service.CashService;
import com.example.cashbook.service.FileService;
import com.example.cashbook.vo.cash.Cash;
import com.example.cashbook.vo.cash.CashFile;
import com.example.cashbook.vo.cash.CashListForm;
import com.example.cashbook.vo.file.FileForm;
import com.example.cashbook.vo.member.Member;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CashController {
	@Autowired CashService cashService;
	@Autowired FileService fileService;
	
	// 월별 캐시달력 출력 (일별 자금흐름 개요)
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
	
	// 일별 캐시리스트 출력
	@GetMapping("/member/cashListByDate")
	public String getCashByDate(Model model, HttpSession session, CashListForm cashListForm, FileForm filmform) {
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
		
		// 특정 캐시 데이터 조회 + 영수증 이미지 출력
		if(filmform.getCashNo() != null) {
			List<CashFile> fileList = fileService.getCashFileList(filmform);
			Cash cash = cashService.getCashOne(filmform.getCashNo());
			model.addAttribute("filmform", filmform);
			model.addAttribute("cash", cash);
			model.addAttribute("fileList", fileList);
		}
		
		return "member/cashListByDate";
	}
	
	
	
//	// 특정 캐시 데이터 조회 + 영수증 이미지 출력
//	@GetMapping("/member/cashOne")
//	public String getCashOne(Model model, @RequestParam int cashNo) {
//		List<CashFile> fileList = fileService.getCashFileList(cashNo);
//		Cash cash = cashService.getCashOne(cashNo);
//		
//		model.addAttribute("cash", cash);
//		model.addAttribute("fileList", fileList);
//		return "on/cashOne";
//	}
	
}
