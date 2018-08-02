package com.bingsin.crm.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class CookiesUtil{

	/**
	 * 
	* @Title: getCookieByName 
	* @Description: 通过名字获取Cookie 
	* @param    
	* @return String    
	* @throws
	 */
	public static String getCookieByName(HttpServletRequest request,String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	* @Title: setCookie 
	* @Description: 保存cookie
	* @param    
	* @return HttpServletResponse    
	* @throws
	 */
	public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value,int time) {
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		try {
			URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(time);
		response.addCookie(cookie);
		return response;
	}
}
