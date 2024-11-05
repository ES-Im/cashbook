package com.example.cashbook.vo;

import java.util.Calendar;

import lombok.Data;
@Data
public class CashCalendar {
	private String memberId;
	// 디폴트 값 = 오늘 날짜
	Calendar now = Calendar.getInstance();
	private int year = now.get(Calendar.YEAR);
	private int month = now.get(Calendar.MONTH) + 1;
	private int day = 1;
}
