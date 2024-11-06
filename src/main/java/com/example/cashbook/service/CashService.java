package com.example.cashbook.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cashbook.mapper.CashMapper;
import com.example.cashbook.vo.cash.CashCalendar;

@Service
@Transactional
public class CashService {
	@Autowired CashMapper cashMapper;
	
	//URL : /member/cashListByMonth  return 달력+수입지출개요 출력 
	public List<Map<String, Object>> getListByMonth(CashCalendar cashCalendar) {
		List<Map<String, Object>> monthCashOutLine = new ArrayList<>();
		
		// 커맨드 DTO 중 파라미터값 변경있으면 적용하기, 변경없으면 CashCalendar 디폴트값대로 적용
		Calendar target = Calendar.getInstance();
		target.set(Calendar.YEAR, cashCalendar.getYear());
		target.set(Calendar.MONTH, cashCalendar.getMonth()-1);
		target.set(Calendar.DATE, cashCalendar.getDay());
		// 캘린더 출력을 위한 셀 설정 변수
		int beginBlank = target.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = target.getActualMaximum(Calendar.DAY_OF_MONTH);
		int totalCell = beginBlank + lastDay;
		if(totalCell % 7 != 0) {
			totalCell += (7- totalCell % 7);
		}
		
		//리스트 길이는 totalCell, for문으로 beginBlank, totalCell-(lastDay+beginBlank) 인덱스는 공백 값 넣기, 
		//beginCell+1 부터 date = 1 , 일별개요 맵에 담아서 list에 담기
		for(int i = 1; i <= totalCell; i++) {
			if(i <= beginBlank || i > lastDay+beginBlank) {
				Map<String, Object> emptyCell = new HashMap<>();
				emptyCell.put("day", 0);
				monthCashOutLine.add(emptyCell);
			} else {
				cashCalendar.setDay(i - beginBlank); // 날짜 설정
		        Map<String, Object> dayOutLineMap = cashMapper.selectCashOutLineInDate(cashCalendar);
		        dayOutLineMap.put("day", i - beginBlank);
		        monthCashOutLine.add(dayOutLineMap);
			}
		}
		
		return monthCashOutLine;
		
	}

	
}
