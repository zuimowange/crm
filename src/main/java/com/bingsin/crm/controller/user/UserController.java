package com.bingsin.crm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bingsin.crm.utils.PropertiesUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired PropertiesUtil propertiesUtil;
	
	@RequestMapping("login")
	public String login(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "user/login";
	}
	@RequestMapping("reg")
	public String reg(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "user/reg";
	}
}
