package com.example.cashbook.vo.comment;

import lombok.Data;

@Data
public class Comment {
	private int commentNo;
	private int noticeNo;
	private String writer;
	private String content;
	private String updateDate;
	private String createDate;
}
