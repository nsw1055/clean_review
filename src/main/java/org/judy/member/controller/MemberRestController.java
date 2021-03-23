package org.judy.member.controller;

import java.util.List;

import org.judy.member.dto.MemberDTO;
import org.judy.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberService service;
	
	@GetMapping(value = "/listJson" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MemberDTO>> getList(){
		
		
		
		return new ResponseEntity<List<MemberDTO>> ( service.getMemberList(), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/read/{mid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MemberDTO> getRead() {
		
		return null;
	}

}
