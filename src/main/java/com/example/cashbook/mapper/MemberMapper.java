package com.example.cashbook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.cashbook.vo.Member;

@Mapper
public interface MemberMapper {
	Member login(Member member);
	List<Member> memberList(Map<String, Object> map);
	int getTotalMemberRow();
	int updateMember(Member member);	// 모든 멤버 (개별)수정용 인터페이스
}
