package org.judy.member.service;

import java.util.List;

import org.judy.member.domain.Member;
import org.judy.member.dto.MemberDTO;
import org.judy.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	
	@Override
	public List<MemberDTO> getMemberList() {
		
		return mapper.getMemberList();
	}

	

}
