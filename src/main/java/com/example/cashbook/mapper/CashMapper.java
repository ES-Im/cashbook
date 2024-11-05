package com.example.cashbook.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cashbook.vo.CashCalendar;

@Mapper
public interface CashMapper {
	Map<String, Object> selectListByMonth(CashCalendar calendar);
}
