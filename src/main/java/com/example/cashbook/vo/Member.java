package com.example.cashbook.vo;

import lombok.Data;

@Data
public class Member {
	private String memberId;
	private String memberPw;
	private String birth;
	private String createDate;
	private String updateDate;
	private int active;
}
