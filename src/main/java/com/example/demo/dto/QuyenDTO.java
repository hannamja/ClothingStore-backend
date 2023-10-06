package com.example.demo.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class QuyenDTO {
	private Integer maquyen;
	private String tenquyen;
	
	public QuyenDTO() {
		super();
	}
	public QuyenDTO(Integer maquyen, String tenquyen) {
		super();
		this.maquyen = maquyen;
		this.tenquyen = tenquyen;
	}
	public Integer getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(Integer maquyen) {
		this.maquyen = maquyen;
	}
	public String getTenquyen() {
		return tenquyen;
	}
	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}
	
}
