package com.bingsin.crm.dao;

import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.po.Role;
import com.bingsin.crm.po.User;
import com.bingsin.crm.po.UserExample;
import com.bingsin.crm.vo.user.UserVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    UserVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 
    * @Title: login 
    * @Description: TODO(登录方法) 
    * @param    
    * @return UserDto    
    * @throws
     */
	UserVo login(User po);

	List<UserVo> list(UserDto dto);

	void updateStateById(Integer id);
}