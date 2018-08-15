package com.bingsin.crm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.UserRoleMapper;
import com.bingsin.crm.dto.user.UserRoleDto;
import com.bingsin.crm.po.UserRole;
import com.bingsin.crm.po.UserRoleExample;
import com.bingsin.crm.service.user.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired UserRoleMapper userRoleMapper;

	@Override
	public void update(UserRoleDto dto) {
		UserRole userRole = userRoleMapper.selectId(dto.getPo());
		if(userRole == null) {
			dto.getPo().setState("0");
			userRoleMapper.insert(dto.getPo());
		}
		else {
			dto.getPo().setId(userRole.getId());
			userRoleMapper.updateByPrimaryKeySelective(dto.getPo());
		}
		
	}
}
