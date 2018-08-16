package com.bingsin.crm.dao;

import com.bingsin.crm.dto.customer.CustomerDto;
import com.bingsin.crm.po.Customer;
import com.bingsin.crm.po.CustomerExample;
import com.bingsin.crm.vo.customer.CustomerVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

	Customer findByTelephone(Customer po);

	List<CustomerVo> list(CustomerDto dto);
}