package com.example.cashbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cashbook.mapper.MemberMapper;
import com.example.cashbook.vo.member.Member;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class MemberService {
	@Autowired MemberMapper memberMapper;
	// URL : /admin/memberList
	public List<Member> getMemberList(Map<String, Object> map) {
		return memberMapper.memberList(map);
	}
	
	// URL : /admin/memberList's LastPage
	public int getListLastPage(int rowPerPage) {
		int totalRow = memberMapper.selectTotalMemberRow();
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage != 0) {
			lastPage++;
		}
		return lastPage;
	}
	
	public int modifyMember(HttpSession session, Member member) {
		// ( 관리자용 ) member_pw 수정시 - 랜덤숫자 4자리
		if(member.getMemberPw() != null && session.getAttribute("adminId") != null) {
			ArrayList<String> randomArr = new ArrayList<>();
			for(int i = 0; i < 4; i++) {
				String randomNum = ((int) Math.floor(Math.random()*9) + 1) + "";
				randomArr.add(randomNum);
			}
			String result = "";
			for(String num : randomArr) {
				result = result + num;
			}
			member.setMemberPw(result);
			log.debug("modifyMember : pw changed");
		}
		
		//  ( 관리자용 )  activity 수정시 1: 활성화 2:휴먼계정
		if(member.getActive() != 0 && session.getAttribute("adminId") != null) {
			if(member.getActive() == 1) {
				member.setActive(2);
			} else {
				member.setActive(1);
			}
			log.debug("modifyMember : activity changed");
		}
		return memberMapper.updateMember(member);
	}

}
