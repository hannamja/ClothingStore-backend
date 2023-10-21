package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.Taikhoan;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class KhachhangDTO {
	private Integer makh;
	
	private String hotenkh;
	private String gioitinh;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaysinh;
	private String sdt;
	private String email;
	private String diachi;
	private String cmnd;
	public Integer getMakh() {
		return makh;
	}
	public void setMakh(Integer makh) {
		this.makh = makh;
	}
//	public Taikhoan getTaikhoan() {
//		return taikhoan;
//	}
//	public void setTaikhoan(Taikhoan taikhoan) {
//		this.taikhoan = taikhoan;
//	}
	public String getHotenkh() {
		return hotenkh;
	}
	public void setHotenkh(String hotenkh) {
		this.hotenkh = hotenkh;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
}
