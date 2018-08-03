package com.bingsin.crm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.UserMapper;
import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper userMapper;
	
	/**
	 * 登录方法
	 */
	public void login(UserDto dto) {
		dto.setPo(userMapper.login(dto.getPo()));
	}

}
