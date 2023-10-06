package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BinhluanDTO {
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaybl;
	private MathangDTO mathangDTO;
	private TaikhoanDTO taikhoanDTO;
	private String noidung;
	
	public BinhluanDTO() {
		super();
	}
	public BinhluanDTO(Date ngaybl, MathangDTO mathangDTO, TaikhoanDTO taikhoanDTO, String noidung) {
		super();
		this.ngaybl = ngaybl;
		this.mathangDTO = mathangDTO;
		this.taikhoanDTO = taikhoanDTO;
		this.noidung = noidung;
	}
	public Date getNgaybl() {
		return ngaybl;
	}
	public void setNgaybl(Date ngaybl) {
		this.ngaybl = ngaybl;
	}
	public MathangDTO getMathangDTO() {
		return mathangDTO;
	}
	public void setMathangDTO(MathangDTO mathangDTO) {
		this.mathangDTO = mathangDTO;
	}
	public TaikhoanDTO getTaikhoanDTO() {
		return taikhoanDTO;
	}
	public void setTaikhoanDTO(TaikhoanDTO taikhoanDTO) {
		this.taikhoanDTO = taikhoanDTO;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	
}
