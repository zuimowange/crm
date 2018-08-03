package com.bingsin.crm.service.role.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.RoleMapper;
import com.bingsin.crm.dto.role.RoleDto;
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

}
