package org.judy.manager.service;

import java.util.List;

import org.judy.manager.domain.Manager;
import org.judy.manager.dto.ManagerDTO;

public interface ManagerService {

	List<ManagerDTO> getMemberList();
	
	ManagerDTO selectOne(String mid);
	
	default ManagerDTO toDto(Manager member) {
		ManagerDTO dto = ManagerDTO.builder()
								.mid(member.getMid())
								.mpw(member.getMpw())
								.email(member.getEmail())
								.logoImg(member.getLogoImg())
								.phone(member.getPhone())
								.enabled(member.getEnabled())
								.approval(member.getApproval())
								.regdate(member.getRegdate())
								.updatedate(member.getUpdatedate())
								.build();
		return dto;
	}
	
	default Manager toDomain(ManagerDTO dto) {
		Manager member = Manager.builder()
							.mid(dto.getMid())
							.mpw(dto.getMpw())
							.email(dto.getEmail())
							.logoImg(dto.getLogoImg())
							.phone(dto.getPhone())
							.enabled(dto.getEnabled())
							.approval(dto.getApproval())
							.regdate(dto.getRegdate())
							.updatedate(dto.getUpdatedate())
							.build();
	return member;
	}
	
}
