package com.example.cashbook.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cashbook.mapper.CashMapper;
import com.example.cashbook.vo.CashCalendar;

@Service
@Transactional
public class CashService {
	@Autowired CashMapper cashMapper;
	
	//return Map<일별 수입,지출 개요>
	public Map<String, Object> getListByMonth(CashCalendar cashCalendar) {
		return cashMapper.selectListByMonth(cashCalendar);
	}
	
	// return Map 캘린더 출력에 필요한 변수, Mapper 없는 Service 메서드
	public Map<String, Integer> getCalendar(CashCalendar cashCalendar) {
		// 커맨드 DTO 중 파라미터값 변경있으면 적용하기, 변경없으면 CashCalendar 디폴트값대로 적용
		Calendar target = Calendar.getInstance();
		target.set(Calendar.YEAR, cashCalendar.getYear());
		target.set(Calendar.MONTH, cashCalendar.getMonth());
		target.set(Calendar.DATE, cashCalendar.getDay());
		// 캘린더 출력을 위해 변수 저장 및 맵에 담기
		int beginBlank = target.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = target.get(Calendar.DAY_OF_MONTH);
		int totalCell = beginBlank + lastDay;
		if(totalCell % 7 != 0) {
			totalCell += (7- totalCell % 7);
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("beginBlank", beginBlank);
		map.put("lastDay", lastDay);
		map.put("totalCell", totalCell);
		
		return map;
	}
	
}
