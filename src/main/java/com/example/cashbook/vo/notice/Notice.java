package com.example.cashbook.vo.notice;

import lombok.Data;

@Data
public class Notice {
	private int noticeNo;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private String createDate;
	private String updateDate;
	private String submittedFilename;
	private String uuidFilename;
}
