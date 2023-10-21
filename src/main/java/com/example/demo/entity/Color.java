package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "color", uniqueConstraints = @UniqueConstraint(columnNames = "TENCOLOR"))
public class Color {
	private String macolor;
	private String tencolor;

	public Color() {
	}

	public Color(String tencolor) {
		this.tencolor = tencolor;
	}

	public Color(String macolor, String tencolor) {
		super();
		this.macolor = macolor;
		this.tencolor = tencolor;
	}

	@Id
	@Column(name = "MACOLOR", unique = true, nullable = false)
	public String getMacolor() {
		return this.macolor;
	}
	
	@Column(name = "TENCOLOR", unique = true, nullable = false)
	public String getTencolor() {
		return tencolor;
	}

	public void setTencolor(String tencolor) {
		this.tencolor = tencolor;
	}

	public void setMacolor(String macolor) {
		this.macolor = macolor;
	}

	
}
