package com.bingsin.crm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsin.crm.config.MsgCode;
import com.bingsin.crm.dto.user.UserRoleDto;
import com.bingsin.crm.service.user.UserRoleService;

@RestController
@RequestMapping("userRoleRest")
public class UserRoleRest {
	
	@Autowired UserRoleService userRoleService;
	
	@RequestMapping("update")
	public UserRoleDto update(UserRoleDto dto) {
		try {
			userRoleService.update(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("修改成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}

}
