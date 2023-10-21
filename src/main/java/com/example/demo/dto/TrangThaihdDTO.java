package com.example.demo.dto;

import lombok.Data;

@Data
public class TrangThaihdDTO {
	private Integer matthd;
	private String trangthai;
	
	public TrangThaihdDTO(Integer matthd, String trangthai) {
		super();
		this.matthd = matthd;
		this.trangthai = trangthai;
	}
	public TrangThaihdDTO() {
		super();
	}
	public Integer getMatthd() {
		return matthd;
	}
	public void setMatthd(Integer matthd) {
		this.matthd = matthd;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
}
