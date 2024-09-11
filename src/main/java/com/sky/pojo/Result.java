package com.sky.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "响应结果")
public class Result<T> {
	
	@Schema(description = "响应码")
	private Boolean code;
	
	@Schema(description = "响应消息")
	private String msg;
	
	@Schema(description = "响应数据")
	private T data;
	
	private Result() {
		
	}
	
	public void setCode(Boolean code) {
		this.code = code;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public Boolean getCode() {
		return this.code;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public static <T> Result<T> success(String msg,T data) {
		Result result = new Result<>();
		result.setCode(true);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	public static <T> Result<T> fail(String msg) {
		Result result = new Result<>();
		result.setCode(false);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}
	
	public String toString() {
		return String.format("Result{code:%d,msg:%s,\ndata:%s}", code?1:0,msg,data.toString());
	}
}
