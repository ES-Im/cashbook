package com.example.cashbook.vo.file;

import lombok.Data;

@Data
public class FileForm {
	private Integer cashFileNo;
	private Integer cashNo;
}

// cashListByDate 에서 특정 Cash 데이터를 조회할때, cashNo만 받아오면 모든 파일의 리스트를 출력, cashFileNo도 같이 넘어오면 특정파일의 이미지정보 출력
