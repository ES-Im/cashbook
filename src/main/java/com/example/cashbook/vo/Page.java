package com.example.cashbook.vo;

import lombok.Data;

@Data
public class Page {
	private int currentPage;
	private int rowPerPage;
	private int lastPage;
	private int beginRow;
}
