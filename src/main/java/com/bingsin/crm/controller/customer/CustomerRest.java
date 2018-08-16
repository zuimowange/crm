package com.bingsin.crm.controller.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsin.crm.config.MsgCode;
import com.bingsin.crm.dto.customer.CustomerDto;
import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.service.customer.CustomerService;

@RestController
@RequestMapping("customerRest")
public class CustomerRest {
	@Autowired CustomerService customerService;

	@RequestMapping("add")
	public CustomerDto add(CustomerDto dto) {
		try {
			boolean flag = customerService.findByTelephone(dto);
			if(flag) {
				customerService.add(dto);
				dto.setCode(MsgCode.REQUEST_SUCCESS);
				dto.setMsg("添加成功");
			}
			else {
				dto.setCode(MsgCode.SERVER_ERROR);
				dto.setMsg("该账号已存在");
			}
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	@RequestMapping("list")
	public CustomerDto customerList(CustomerDto dto) {
		try {
			customerService.list(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
}
