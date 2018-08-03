package com.bingsin.crm.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingsin.crm.utils.PropertiesUtil;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired PropertiesUtil propertiesUtil;

	@RequestMapping("roleList")
	public String roleList(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "role/role_list";
	}
}
