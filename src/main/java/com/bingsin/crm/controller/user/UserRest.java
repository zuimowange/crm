package com.bingsin.crm.controller.user;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingsin.crm.config.MsgCode;
import com.bingsin.crm.dto.user.UserDto;
import com.bingsin.crm.service.user.UserService;
import com.bingsin.crm.vo.Token;
import com.bingsin.crm.utils.Base64Util;
import com.bingsin.crm.utils.CookiesUtil;
import com.bingsin.crm.utils.DateUtil;
import com.bingsin.crm.utils.Md5Util;
import com.bingsin.crm.utils.PropertiesUtil;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("userRest")
public class UserRest {

	@Autowired UserService userService;
	@Autowired Md5Util md5Util;
	@Autowired DateUtil dateUtil;
	@Autowired Base64Util base64Util;
	@Autowired CookiesUtil cookieUtil;
	@Autowired PropertiesUtil propertiesUtil;

	@RequestMapping("/login")
	public UserDto login(UserDto dto,HttpServletResponse response,HttpServletRequest request) {
		try {
			userService.login(dto);
			if(dto.getPo() != null) {
				if(dto.getPo().getState().equals("0")) {
					//生成token
					Date iat = new Date();
					Date exp = dateUtil.changeDate(iat, Calendar.DATE, 10);				
					Token token = new Token(dto.getPo().getId(),dateUtil.dateToStamp(iat));
					JSONObject map = JSONObject.fromObject(token);
					//token加密
					String tokens = base64Util.base64Encoder(map.toString());
					//dto.setToken(tokens);
					cookieUtil.setCookie(response, "token", tokens, 3600*24*new Integer(propertiesUtil.getCookieLife()));
					dto.setCode(MsgCode.REQUEST_SUCCESS);
					dto.setMsg("登录成功");
				}
				else {
					dto.setCode(MsgCode.REQUEST_FAIL);
					dto.setMsg("该账号已冻结");
				}
			}
			else {
				dto.setCode(MsgCode.REQUEST_FAIL);
				dto.setMsg("登录失败");
			}
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	@RequestMapping("/findNameById")
	public String findNameById(UserDto dto) {
		try {
			userService.findById(dto);
			return dto.getPo().getUserName();
		} catch (Exception e) {
			return "游客";
		}
	}
	
	@RequestMapping("list")
	public UserDto userList(UserDto dto) {
		try {
			userService.list(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	
	@RequestMapping("updateById")
	public UserDto updateById(UserDto dto) {
		try {
			userService.updateById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
	@RequestMapping("updateStateById")
	public UserDto updateStateById(UserDto dto) {
		try {
			userService.updateStateById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("updateStateByIds")
	public UserDto updateStateByIds(UserDto dto) {
		try {
			userService.updateStateByIds(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("deleteById")
	public UserDto deleteById(UserDto dto) {
		try {
			userService.deleteById(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("deleteByIds")
	public UserDto deleteByIds(UserDto dto) {
		try {
			userService.deleteByIds(dto);
			dto.setCode(MsgCode.REQUEST_SUCCESS);
			dto.setMsg("请求成功");
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	@RequestMapping("add")
	public UserDto add(UserDto dto) {
		try {
			boolean flag = userService.findAccount(dto);
			if(flag) {
				userService.add(dto);
				dto.setCode(MsgCode.REQUEST_SUCCESS);
				dto.setMsg("添加成功");
			}
			else {
				dto.setCode(MsgCode.SERVER_ERROR);
				dto.setMsg("该账号已存在");
			}
		} catch (Exception e) {
			dto.setCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
	
}
