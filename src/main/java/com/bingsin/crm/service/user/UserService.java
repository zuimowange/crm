package com.bingsin.crm.service.user;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.user.UserDto;

@Service
public interface UserService {

	void login(UserDto dto);

	void findById(UserDto dto);

	void list(UserDto dto);

	void updateById(UserDto dto);

	void updateStateById(UserDto dto);

	void updateStateByIds(UserDto dto);

	void deleteById(UserDto dto);

	void deleteByIds(UserDto dto);

	void add(UserDto dto);

	boolean findAccount(UserDto dto);

	void allUser(UserDto dto);


}
