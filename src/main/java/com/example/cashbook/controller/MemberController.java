package com.example.cashbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cashbook.mapper.MemberMapper;
import com.example.cashbook.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired MemberMapper memberMapper;
	// 멤버 리스트 출력 (어드민관리용)
	@GetMapping("/admin/memberList")
	public String memberList(Model model, @RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue = "10") int rowPerPage) {
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", (currentPage-1)*rowPerPage);
		map.put("rowPerPage", rowPerPage);
		
		List<Member> memberList = memberMapper.memberList(map);
		int totalRow = memberMapper.getTotalMemberRow();
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage != 0) {
			lastPage++;
		}
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage", lastPage);
		
		return "admin/memberList";
	}
	// 멤버 계정잠금/활성화 (어드민 관리용)
	@GetMapping("/admin/editMemberActivity")
	public String editActivity(Member member) {
		if(member.getActive() == 1) {
			member.setActive(2);
		} else {
			member.setActive(1);
		}
		memberMapper.updateMember(member);
		return "redirect:/admin/memberList";
	}
	

}
