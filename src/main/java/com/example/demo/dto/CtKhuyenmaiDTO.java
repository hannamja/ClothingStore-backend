package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.CtKhuyenmaiId;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Mathang;

public class CtKhuyenmaiDTO {
	private CtKhuyenmaiId id;
	private Date ngaybd;
	private Date ngaykt;
	private String mucgiam;
	public CtKhuyenmaiDTO(CtKhuyenmaiId id, Date ngaybd, Date ngaykt, String mucgiam) {
		super();
		this.id = id;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
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
	public Date getNgaybd() {
		return ngaybd;
	}
	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}
	public Date getNgaykt() {
		return ngaykt;
	}
	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}
	public String getMucgiam() {
		return mucgiam;
	}
	public void setMucgiam(String mucgiam) {
		this.mucgiam = mucgiam;
	}
	
}
