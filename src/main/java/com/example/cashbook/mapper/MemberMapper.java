package com.example.cashbook.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.cashbook.vo.Member;

@Mapper
public interface MemberMapper {
	Member login(Member member);

}
