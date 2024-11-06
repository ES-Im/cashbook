package com.example.cashbook.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cashbook.vo.cash.CashCalendar;

@Mapper
public interface CashMapper {
	// Map<특정 일에 맞는 수입/지출/합계 
	Map<String, Object> selectCashOutLineInDate(CashCalendar calendar);
}
