package com.bingsin.crm.service.user;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.user.UserRoleDto;

@Service
public interface UserRoleService {

	void update(UserRoleDto dto);

}
