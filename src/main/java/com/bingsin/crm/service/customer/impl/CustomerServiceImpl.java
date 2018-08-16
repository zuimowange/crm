package com.bingsin.crm.service.customer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsin.crm.dao.CustomerMapper;
import com.bingsin.crm.dto.customer.CustomerDto;
import com.bingsin.crm.dto.role.RoleDto;
import com.bingsin.crm.po.Customer;
import com.bingsin.crm.po.CustomerExample;
import com.bingsin.crm.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired CustomerMapper customerMapper;

	@Override
	public boolean findByTelephone(CustomerDto dto) {
		Customer customer = customerMapper.findByTelephone(dto.getPo());
		if(customer == null) {
			return true;
		}
		return false;
	}

	@Override
	public void add(CustomerDto dto) {
		dto.getPo().setTime(new Date());
		customerMapper.insertSelective(dto.getPo());
	}
	@Override
	public void list(CustomerDto dto) {
		dto.setStart((dto.getPage()-1)*dto.getLimit());
		dto.setData(customerMapper.list(dto));
		CustomerExample example = new CustomerExample();
		dto.setCount(customerMapper.countByExample(example));
	}

	
}
