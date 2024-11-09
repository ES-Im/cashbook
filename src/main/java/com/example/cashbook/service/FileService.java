package com.example.cashbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cashbook.mapper.FileMapper;
import com.example.cashbook.vo.cash.CashFile;
import com.example.cashbook.vo.cash.CashListForm;
import com.example.cashbook.vo.file.FileForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {
	@Autowired FileMapper fileMapper;
	public List<CashFile> getCashFileList(FileForm no) {
		return fileMapper.selectCashFileList(no);
	}

}
