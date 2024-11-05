package com.example.cashbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cashbook.mapper.AdminMapper;
import com.example.cashbook.mapper.MemberMapper;
import com.example.cashbook.vo.Admin;
import com.example.cashbook.vo.Member;

@Service
@Transactional
public class LoginService {
	@Autowired MemberMapper memberMapper;
	@Autowired AdminMapper adminMapper;
	
	// Member login -------------------------------------
	public Member login(Member member) {
		return memberMapper.login(member);
	}
	
	// Admin login ---------------------------------------
	public Admin login(Admin admin) {
		return adminMapper.login(admin);
	}

}
