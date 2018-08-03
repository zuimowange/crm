package com.bingsin.crm.service.role;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.role.RoleDto;

@Service
public interface RoleService {

	void roleList(RoleDto dto);

}
