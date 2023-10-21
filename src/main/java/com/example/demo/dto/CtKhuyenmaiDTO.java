package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.CtKhuyenmaiId;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Mathang;

public class CtKhuyenmaiDTO {
	private CtKhuyenmaiId id;
	private String mucgiam;
	public CtKhuyenmaiDTO(CtKhuyenmaiId id, String mucgiam) {
		super();
		this.id = id;
		this.mucgiam = mucgiam;
	}
	public CtKhuyenmaiDTO() {
		// TODO Auto-generated constructor stub
	}
	public CtKhuyenmaiId getId() {
		return id;
	}
	public void setId(CtKhuyenmaiId id) {
		this.id = id;
	}
	public String getMucgiam() {
		return mucgiam;
	}
	public void setMucgiam(String mucgiam) {
		this.mucgiam = mucgiam;
	}
	
}
