package com.bingsin.crm.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingsin.crm.utils.PropertiesUtil;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired PropertiesUtil propertiesUtil;

	@RequestMapping("customerList")
	public String customerList(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "customer/customer_list";
	}
}
