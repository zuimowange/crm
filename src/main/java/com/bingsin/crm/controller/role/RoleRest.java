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
	
	@RequestMapping("list")
	public RoleDto roleList(RoleDto dto) {
		try {
			roleService.list(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param    
	* @return RoleDto    
	* @throws
	 */
	@RequestMapping("updateById")
	public RoleDto updateById(RoleDto dto) {
		try {
			roleService.updateById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	@RequestMapping("updateStateById")
	public RoleDto updateStateById(RoleDto dto) {
		try {
			roleService.updateStateById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("updateStateByIds")
	public RoleDto updateStateByIds(RoleDto dto) {
		try {
			roleService.updateStateByIds(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("deleteById")
	public RoleDto deleteById(RoleDto dto) {
		try {
			roleService.deleteById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("deleteByIds")
	public RoleDto deleteByIds(RoleDto dto) {
		try {
			roleService.deleteByIds(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("add")
	public RoleDto add(RoleDto dto) {
		try {
			boolean flag = roleService.findRoleName(dto);
			if(flag) {
				roleService.add(dto);
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
	
	@RequestMapping("allRole")
	public RoleDto allRole(RoleDto dto) {
		try {
			roleService.allRole(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	@RequestMapping("ableRole")
	public RoleDto ableRole(RoleDto dto) {
		try {
			roleService.ableRole(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
}
