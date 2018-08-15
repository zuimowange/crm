package com.bingsin.crm.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.UserMapper;
import com.bingsin.crm.dao.UserRoleMapper;
import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.po.RoleExample;
import com.bingsin.crm.po.User;
import com.bingsin.crm.po.UserExample;
import com.bingsin.crm.po.UserRole;
import com.bingsin.crm.service.user.UserService;
import com.bingsin.crm.utils.Base64Util;
import com.bingsin.crm.vo.user.UserVo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper userMapper;
	@Autowired UserRoleMapper userRoleMapper;
	@Autowired Base64Util base64Util;
	
	/**
	 * 登录方法
	 */
	public void login(UserDto dto) {
		dto.setPo(userMapper.login(dto.getPo()));
	}

	/**
	 * 根据ID查找user
	 */
	@Override
	public void findById(UserDto dto) {
		dto.setPo(userMapper.selectByPrimaryKey(dto.getPo().getId()));
	}

	@Override
	public void list(UserDto dto) {
		dto.setStart((dto.getPage()-1)*dto.getLimit());
		dto.setData(userMapper.list(dto));
		UserExample example = new UserExample();
		dto.setCount(userMapper.countByExample(example));
	}

	@Override
	public void updateById(UserDto dto) {
		userMapper.updateByPrimaryKeySelective(dto.getPo());
	}

	@Override
	public void updateStateById(UserDto dto) {
		userMapper.updateStateById(dto.getPo().getId());
	}

	@Override
	public void updateStateByIds(UserDto dto) {
		String[] ids = dto.getIds().split(",");
		for(String id:ids) {
			userMapper.updateStateById(new Integer(id));
		}
	}

	@Override
	public void deleteById(UserDto dto) {
		userMapper.deleteByPrimaryKey(dto.getPo().getId());
	}

	@Override
	public void deleteByIds(UserDto dto) {
		String[] ids = dto.getIds().split(",");
		for(String id:ids) {
			userMapper.deleteByPrimaryKey(new Integer(id));
		}
	}

	@Override
	public void add(UserDto dto) {
		dto.getPo().setState("0");
		String pwd = base64Util.base64Decoder(dto.getPo().getPwd());
		dto.getPo().setTime(new Date());
		userMapper.insert(dto.getPo());
		UserRole userRole = new UserRole();
		userRole.setUserId(dto.getPo().getId());
		userRole.setRoleId(dto.getPo().getRoleId());
		userRole.setState("0");
		userRole.setTime(new Date());
		userRoleMapper.insert(userRole);
	}

	@Override
	public boolean findAccount(UserDto dto) {
		User user = userMapper.findAccount(dto.getPo());
		if(user == null) {
			return true;
		}
		return false;
	}

}
