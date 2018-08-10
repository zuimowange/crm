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

    /**
     * 
    * @Title: roleList 
    * @Description: TODO(分页获取角色列表) 
    * @param    
    * @return List<Role>    
    * @throws
     */
	List<Role> list(RoleDto dto);

	/**
	 * 
	* @Title: updateState 
	* @Description: TODO(修改状态) 
	* @param    
	* @return void    
	* @throws
	 */
	void updateStateById(Integer id);

	/**
	 * 
	* @Title: allRole 
	* @Description: TODO(查询所有角色) 
	* @param    
	* @return List<Role>    
	* @throws
	 */
	List<Role> allRole();
}