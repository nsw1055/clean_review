package org.judy.manager.mapper;

import java.util.List;

import org.judy.manager.domain.Manager;
import org.judy.manager.dto.ManagerDTO;

public interface ManagerMapper {

	public List<ManagerDTO> getMemberList();
	
	public Manager selectOne(String mid);
}
