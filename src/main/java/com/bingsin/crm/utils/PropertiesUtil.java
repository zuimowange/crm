package com.bingsin.crm.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("propertiesUtil")
public class PropertiesUtil {

	@Value("${crm.baseHref}")
	private String baseHref;
	@Value("${crm.key}")
	private String key;
	@Value("${crm.cookie.life}")
	private String cookieLife;
	public String getBaseHref() {
		return baseHref;
	}
	public void setBaseHref(String baseHref) {
		this.baseHref = baseHref;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCookieLife() {
		return cookieLife;
	}
	public void setCookieLife(String cookieLife) {
		this.cookieLife = cookieLife;
	}
	
}
