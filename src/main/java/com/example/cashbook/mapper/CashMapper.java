package com.example.cashbook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.example.cashbook.vo.cash.Cash;
import com.example.cashbook.vo.cash.CashListForm;

@Mapper
public interface CashMapper {
	// /member/cashListByMonth Map<특정 일에 맞는 수입/지출/합계 
	Map<String, Object> selectCashOutLineInDate(CashListForm cashListForm);
	// /member/cashListByDate LIST<일별 리스트 업> 
	List<Cash> selectListByDate(CashListForm cashListForm);
	// /member/cashListByDate : LastPage 변수 구하는데 사용(총 인스턴스 수 구하기)
	int selectTotalInstance(CashListForm cashListForm);
	// /member/cashOne : 특정 캐시정보 출력
	Cash selectCashOne(int cashNo);

}
