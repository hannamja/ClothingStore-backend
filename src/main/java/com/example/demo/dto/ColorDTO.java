package com.example.demo.dto;

import javax.persistence.Column;

public class ColorDTO {
	private String macolor;
	private String tencolor;
	
	public ColorDTO() {
		super();
	}

	public String getMacolor() {
		return macolor;
	}

	public void setMacolor(String macolor) {
		this.macolor = macolor;
	}

	public String getTencolor() {
		return tencolor;
	}

	public void setTencolor(String tencolor) {
		this.tencolor = tencolor;
	}

	public ColorDTO(String macolor, String tencolor) {
		super();
		this.macolor = macolor;
		this.tencolor = tencolor;
	}
	
	
	
}
