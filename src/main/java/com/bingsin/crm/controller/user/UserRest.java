package com.bingsin.crm.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsin.crm.dto.user.UserDto;

@RestController
@RequestMapping("userRest")
public class UserRest {

	@RequestMapping("/login")
	public UserDto test(UserDto dto) {
		return dto;
	}
}
