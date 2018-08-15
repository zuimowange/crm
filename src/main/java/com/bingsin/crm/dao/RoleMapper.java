package com.bingsin.crm.dao;

import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.po.Role;
import com.bingsin.crm.po.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
	List<Role> list(RoleDto dto);
	
	void updateStateById(Integer id);
	
	List<Role> allRole();

	List<Role> ableRole();

	Role findRoleName(Role role);
}