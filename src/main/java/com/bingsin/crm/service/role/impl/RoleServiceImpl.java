package com.bingsin.crm.service.role.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	public void roleList(RoleDto dto) {
		dto.setStart((dto.getPage()-1)*dto.getLimit());
		dto.setData(roleMapper.roleList(dto));
		RoleExample example = new RoleExample();
		dto.setCount(roleMapper.countByExample(example));
	}

	@Override
	public void updateById(RoleDto dto) {
		roleMapper.updateByPrimaryKey(dto.getPo());
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

}