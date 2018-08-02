package com.bingsin.crm.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingsin.crm.utils.PropertiesUtil;


@Controller
public class MainController {

	@Autowired PropertiesUtil propertiesUtil;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "main/index";
		
	}
	
}
