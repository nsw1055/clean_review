package org.judy.manager.controller;

import org.judy.manager.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
@Log4j
public class ManagerController {

	private final ManagerService service;
	
	@GetMapping("/list")
	public void getList(Model model) {
//		log.info("getList...............");
//		model.addAttribute("list" , service.getMemberList());
	}
	
	@GetMapping("/read")
	public void getRead(Model model) {
//		log.info("getList...............");
//		model.addAttribute("list" , service.getMemberList());
	}
}
