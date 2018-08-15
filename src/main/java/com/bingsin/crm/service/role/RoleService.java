package com.bingsin.crm.service.role;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.role.RoleDto;

@Service
public interface RoleService {

	void list(RoleDto dto);

	void updateById(RoleDto dto);

	void updateStateById(RoleDto dto);
	
	void updateStateByIds(RoleDto dto);

	void deleteById(RoleDto dto);

	void deleteByIds(RoleDto dto);

	void add(RoleDto dto);

	void allRole(RoleDto dto);

	void ableRole(RoleDto dto);

}
