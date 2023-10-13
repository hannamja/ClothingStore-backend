package com.example.demo.dto;

public class SizeDTO {
	private String masize;
	private String tensize;
	public String getMasize() {
		return masize;
	}
	public void setMasize(String masize) {
		this.masize = masize;
	}
	public String getTensize() {
		return tensize;
	}
	public void setTensize(String tensize) {
		this.tensize = tensize;
	}
	public SizeDTO(String masize, String tensize) {
		super();
		this.masize = masize;
		this.tensize = tensize;
	}
	public SizeDTO() {
		super();
	}
	
	
}
