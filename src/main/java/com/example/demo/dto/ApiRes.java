package com.example.demo.dto;

public class ApiRes {
	private String errCode;
	private String message;
	private Object data;
	
	public ApiRes() {
		
	}
	
	public ApiRes(String errCode, String message, Object data) {
		super();
		this.errCode = errCode;
		this.message = message;
		this.data = data;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
