package com.example.demo.dto;

import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;

public class TaikhoanDTO {
	private Integer matk;
//	private KhachhangDTO khachhangDTO;
//	private NhanvienDTO nhanvienDTO;
	private String email;
	private String matkhau;
	public TaikhoanDTO(Integer matk, KhachhangDTO khachhangDTO, NhanvienDTO nhanvienDTO, String email, String matkhau) {
		super();
		this.matk = matk;
//		this.khachhangDTO = khachhangDTO;
//		this.nhanvienDTO = nhanvienDTO;
		this.email = email;
		this.matkhau = matkhau;
	}
	
	public TaikhoanDTO(Integer matk) {
		super();
		this.matk = matk;
	}

	public TaikhoanDTO() {
		super();
	}
	public Integer getMatk() {
		return matk;
	}
	public void setMatk(Integer matk) {
		this.matk = matk;
	}
//	public KhachhangDTO getKhachhangDTO() {
//		return khachhangDTO;
//	}
//	public void setKhachhangDTO(KhachhangDTO khachhangDTO) {
//		this.khachhangDTO = khachhangDTO;
//	}
//	public NhanvienDTO getNhanvienDTO() {
//		return nhanvienDTO;
//	}
//	public void setNhanvienDTO(NhanvienDTO nhanvienDTO) {
//		this.nhanvienDTO = nhanvienDTO;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
}
