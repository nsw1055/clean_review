package org.judy.member.controller;

import org.judy.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/list")
	public void getList(Model model) {
//		log.info("getList...............");
//		model.addAttribute("list" , service.getMemberList());
	}
}
