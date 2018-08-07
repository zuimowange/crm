package com.bingsin.crm.service.user;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.po.User;

@Service
public interface UserService {

	void login(UserDto dto);

	void findById(UserDto dto);


}
