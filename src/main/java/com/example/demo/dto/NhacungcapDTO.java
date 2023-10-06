package com.example.demo.dto;

import lombok.Data;

@Data
public class NhacungcapDTO {
	private Integer mancc;
	private String tenncc;
	private String diachi;
	private String sodt;
	private String email;
	public NhacungcapDTO(Integer mancc, String tenncc, String diachi, String sodt, String email) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.diachi = diachi;
		this.sodt = sodt;
		this.email = email;
	}
	public NhacungcapDTO() {
		super();
	}
	
	public NhacungcapDTO(Integer mancc, String tenncc) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
	}
	public Integer getMancc() {
		return mancc;
	}
	public void setMancc(Integer mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
