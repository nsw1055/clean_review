package org.judy.member.service;

import java.util.List;

import org.judy.member.domain.Member;
import org.judy.member.dto.MemberDTO;

public interface MemberService {

	List<MemberDTO> getMemberList();
	
	default MemberDTO toDto(Member member) {
		MemberDTO dto = MemberDTO.builder()
								.mid(member.getMid())
								.mpw(member.getMpw())
								.nickname(member.getNickname())
								.mname(member.getMname())
								.birth(member.getBirth())
								.email(member.getEmail())
								.img(member.getImg())
								.phone(member.getPhone())
								.regdate(member.getRegdate())
								.updatedate(member.getUpdatedate())
								.build();
		return dto;
	}
	
	default Member toDomain(MemberDTO dto) {
		Member member = Member.builder()
							.mid(dto.getMid())
							.mpw(dto.getMpw())
							.nickname(dto.getNickname())
							.mname(dto.getMname())
							.birth(dto.getBirth())
							.email(dto.getEmail())
							.img(dto.getImg())
							.phone(dto.getPhone())
							.regdate(dto.getRegdate())
							.updatedate(dto.getUpdatedate())
							.build();
	return member;
	}
	
}
