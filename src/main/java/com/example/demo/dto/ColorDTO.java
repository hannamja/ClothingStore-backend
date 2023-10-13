package com.example.demo.dto;

public class ColorDTO {
	private String mamau;
	private String tenmau;
	public String getMamau() {
		return mamau;
	}
	public void setMamau(String mamau) {
		this.mamau = mamau;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public ColorDTO(String mamau, String tenmau) {
		super();
		this.mamau = mamau;
		this.tenmau = tenmau;
	}
	public ColorDTO() {
		super();
	}
	
	
	
}
