package com.bingsin.crm.dto.user;

import com.bingsin.crm.dto.AbstractBaseDto;
import com.bingsin.crm.po.User;

public class UserDto extends AbstractBaseDto<User>{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -7884291922588131869L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}