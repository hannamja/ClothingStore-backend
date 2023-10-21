package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.Taikhoan;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class NhanvienDTO {
	private Integer manv;
	private String tennv;
	private String gioitinh;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaysinh;
	private String sdt;
	private String diachi;
	private String email;
	private String cmnd;
	private String trangthai;
	
	
	public NhanvienDTO() {
		super();
	}
	public NhanvienDTO(Integer manv, String tennv) {
		super();
		this.manv = manv;
		this.tennv = tennv;
	}
	public Integer getManv() {
		return manv;
	}
	public void setManv(Integer manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
}
