package com.example.demo.dto;

import lombok.Data;

@Data
public class NhanhieuDTO {
	private Integer manh;
	private String tennh;
	public NhanhieuDTO(Integer manh, String tennh) {
		super();
		this.manh = manh;
		this.tennh = tennh;
	}
	public NhanhieuDTO() {
		super();
	}
	public Integer getManh() {
		return manh;
	}
	public void setManh(Integer manh) {
		this.manh = manh;
	}
	public String getTennh() {
		return tennh;
	}
	public void setTennh(String tennh) {
		this.tennh = tennh;
	}
	
}
