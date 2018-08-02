package com.bingsin.crm.vo;

public class Token {
	private Integer userId;//userID
	private String iat;//token生成时间
	private String exp;//token生命周期，到期时间
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Token(Integer userId, String iat, String exp) {
		super();
		this.userId = userId;
		this.iat = iat;
		this.exp = exp;
	}
	public Token(Integer userId,  String exp) {
		super();
		this.userId = userId;
		this.exp = exp;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
}
