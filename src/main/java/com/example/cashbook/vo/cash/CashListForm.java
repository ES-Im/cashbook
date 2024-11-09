package com.example.cashbook.vo.cash;
// 월별 수입지출 개요 + 일별 수입지출 (매개변수) 리스트 폼
import java.util.Calendar;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class CashListForm {
	private Integer cashNo;
	
	private String memberId;
	private int income;
	private int outcome;
	private int total;
	private String kind;
	
	// 날짜 세팅을 위한 변수, 디폴트 값 = 오늘 날짜
	Calendar now = Calendar.getInstance();
	private int year = now.get(Calendar.YEAR);
	private int month = now.get(Calendar.MONTH) + 1;
	private int day = 1;
	
	// 페이징을 위한 변수, (디폴트 값 1, 10)
	private int currentPage = 1;
	private int rowPerPage = 10;
	private int beginRow;
	
	// 특정 캐시 data의 파일정보 
	private List<MultipartFile> cashFile;

}


