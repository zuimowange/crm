package com.bingsin.crm.service.user;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.user.UserDto;

@Service
public interface UserService {

	void login(UserDto dto);

}
