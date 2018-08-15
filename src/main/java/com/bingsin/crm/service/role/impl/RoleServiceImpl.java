package com.bingsin.crm.service.role.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.RoleMapper;
import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.po.Role;
import com.bingsin.crm.po.RoleExample;
import com.bingsin.crm.service.role.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired RoleMapper roleMapper;
	
	@Override
	public void list(RoleDto dto) {
		dto.setStart((dto.getPage()-1)*dto.getLimit());
		dto.setData(roleMapper.list(dto));
		RoleExample example = new RoleExample();
		dto.setCount(roleMapper.countByExample(example));
	}

	@Override
	public void updateById(RoleDto dto) {
		roleMapper.updateByPrimaryKeySelective(dto.getPo());
	}

	@Override
	public void updateStateById(RoleDto dto) {
		roleMapper.updateStateById(dto.getPo().getId());
	}
	
	@Override
	public void updateStateByIds(RoleDto dto) {
		String[] ids = dto.getIds().split(",");
		for(String id:ids) {
			roleMapper.updateStateById(new Integer(id));
		}
	}

	@Override
	public void deleteById(RoleDto dto) {
		roleMapper.deleteByPrimaryKey(dto.getPo().getId());
	}
	
	@Override
	public void deleteByIds(RoleDto dto) {
		String[] ids = dto.getIds().split(",");
		for(String id:ids) {
			roleMapper.deleteByPrimaryKey(new Integer(id));
		}
	}

	@Override
	public void add(RoleDto dto) {
		dto.getPo().setState("0");
		dto.getPo().setTime(new Date());
		roleMapper.insert(dto.getPo());
	}

	/**
	 * 查询所有用户（用户下拉菜单）
	 */
	@Override
	public void allRole(RoleDto dto) {
		dto.setData(roleMapper.allRole());
	}

	@Override
	public void ableRole(RoleDto dto) {
		dto.setData(roleMapper.ableRole());
	}

	@Override
	public boolean findRoleName(RoleDto dto) {
		Role role = roleMapper.findRoleName(dto.getPo());
		if(role == null) {
			return true;
		}
		return false;
	}

}
