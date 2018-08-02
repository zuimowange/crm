package com.bingsin.crm.dao;

import com.bingsin.crm.po.WorkList;
import com.bingsin.crm.po.WorkListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkListMapper {
    long countByExample(WorkListExample example);

    int deleteByExample(WorkListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkList record);

    int insertSelective(WorkList record);

    List<WorkList> selectByExample(WorkListExample example);

    WorkList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkList record, @Param("example") WorkListExample example);

    int updateByExample(@Param("record") WorkList record, @Param("example") WorkListExample example);

    int updateByPrimaryKeySelective(WorkList record);

    int updateByPrimaryKey(WorkList record);
}