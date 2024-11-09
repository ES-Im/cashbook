package com.example.cashbook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.cashbook.vo.cash.CashFile;
import com.example.cashbook.vo.cash.CashListForm;
import com.example.cashbook.vo.file.FileForm;

@Mapper
public interface FileMapper {
	List<CashFile> selectCashFileList(FileForm fileForm);
}
