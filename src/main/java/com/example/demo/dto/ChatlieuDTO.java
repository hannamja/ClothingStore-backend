package com.example.demo.dto;

import lombok.Data;

@Data
public class ChatlieuDTO {
	private Integer macl;
	private String tenvai;
	public ChatlieuDTO(Integer macl, String tenvai) {
		super();
		this.macl = macl;
		this.tenvai = tenvai;
	}
	public ChatlieuDTO() {
		super();
	}
	public Integer getMacl() {
		return macl;
	}
	public void setMacl(Integer macl) {
		this.macl = macl;
	}
	public String getTenvai() {
		return tenvai;
	}
	public void setTenvai(String tenvai) {
		this.tenvai = tenvai;
	}
	
}
