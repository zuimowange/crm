package com.bingsin.crm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.UserMapper;
import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.po.RoleExample;
import com.bingsin.crm.po.User;
import com.bingsin.crm.po.UserExample;
import com.bingsin.crm.service.user.UserService;
import com.bingsin.crm.vo.user.UserVo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper userMapper;
	
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
		userMapper.insert(dto.getPo());
	}

}
