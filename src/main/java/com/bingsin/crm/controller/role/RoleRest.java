package com.bingsin.crm.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsin.crm.config.MsgCode;
import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.service.role.RoleService;

@RestController
@RequestMapping("roleRest")
public class RoleRest {
	
	@Autowired RoleService roleService;
	
	@RequestMapping("roleList")
	public RoleDto roleList(RoleDto dto) {
		try {
			roleService.roleList(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}

}
