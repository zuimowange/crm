package com.bingsin.crm.controller.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingsin.crm.utils.Base64Util;
import com.bingsin.crm.utils.CookiesUtil;
import com.bingsin.crm.utils.PropertiesUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired PropertiesUtil propertiesUtil;
	@Autowired CookiesUtil cookiesUtil;
	
	/**
	 * 
	* @Title: login 
	* @Description: TODO(跳转登录页面，如果发现cookie中存在token,则直接跳转到其他页面,如果不存在token,则跳转到登录页面) 
	* @param    
	* @return String    
	* @throws
	 */
	@RequestMapping("login")
	public String login(Model model,HttpServletRequest request) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		String token = cookiesUtil.getCookieByName(request, "token");
		if(token != null) {
			return "main/main";
		}
		return "user/login";
	}
	@RequestMapping("reg")
	public String reg(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "user/reg";
	}
	@RequestMapping("userList")
	public String userList(Model model) {
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "user/user_list";
	}
}
