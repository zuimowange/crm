package com.bingsin.crm.service.customer;

import org.springframework.stereotype.Service;

import com.bingsin.crm.dto.customer.CustomerDto;

@Service
public interface CustomerService {

	boolean findByTelephone(CustomerDto dto);

	void add(CustomerDto dto);

	void list(CustomerDto dto);

}
