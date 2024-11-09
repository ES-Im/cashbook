package com.example.cashbook.vo.cash;

import lombok.Data;

@Data
public class CashFile {
	
	private int cashFileNo;		// PK
	private int cashNo;			// FK
	private String originName;
	private String fileName;
	private String ext;
	private String contentType;
	private long size;
	private String createDate;
	
}
