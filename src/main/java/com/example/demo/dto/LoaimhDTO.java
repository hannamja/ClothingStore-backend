package com.example.demo.dto;

import lombok.Data;

@Data
public class LoaimhDTO {
	private Integer maloaimh;
	private String tenloadimh;
	public Integer getMaloaimh() {
		return maloaimh;
	}
	public void setMaloaimh(Integer maloaimh) {
		this.maloaimh = maloaimh;
	}
	public String getTenloadimh() {
		return tenloadimh;
	}
	public void setTenloadimh(String tenloadimh) {
		this.tenloadimh = tenloadimh;
	}
	
}
