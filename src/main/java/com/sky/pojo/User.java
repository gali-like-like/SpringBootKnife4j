package com.sky.pojo;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Base64;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户登录")
public class User {
	
	private static Integer times = 1;
	
	@Schema(description = "用户账号")
	private String account;
	
	@Schema(description = "用户密码")
	private String password;
	
	@Schema(description = "用户id")
	private Integer userId;
	
	{
		userId = times;
		String src = String.valueOf(Instant.now().toEpochMilli()+times);
		String dsc = Base64.getEncoder().encodeToString(src.getBytes(Charset.forName("utf-8")));
		account = dsc;
		times++;
	}
	
	public User() {
		
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public String toString() {
		return String.format("User{userId:%d,account:%s,password:%s}", userId,account,password);
	}
}
