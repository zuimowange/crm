package com.bingsin.crm.vo.customer;

import java.io.Serializable;

import com.bingsin.crm.po.Customer;

public class CustomerVo extends Customer implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 8182382408572336322L;

	private String refereeName;
	private String inputPersonName;
	public String getRefereeName() {
		return refereeName;
	}
	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}
	public String getInputPersonName() {
		return inputPersonName;
	}
	public void setInputPersonName(String inputPersonName) {
		this.inputPersonName = inputPersonName;
	}
}
