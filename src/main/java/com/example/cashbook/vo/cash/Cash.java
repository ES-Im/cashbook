package com.example.cashbook.vo.cash;

import lombok.Data;

@Data
public class Cash {
	private int cashNo;
	private String memberId;
	private String cashDate;
	private String kind;
	private int money;
	private String memo;
	private String createDate;
	private String updateDate;
}
