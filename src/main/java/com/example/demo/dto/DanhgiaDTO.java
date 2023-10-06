package com.example.demo.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class DanhgiaDTO {
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaybl;
	private MathangDTO mathangDTO;
	private TaikhoanDTO taikhoanDTO;
	private Integer number;
	public DanhgiaDTO(Date ngaybl, MathangDTO mathangDTO, TaikhoanDTO taikhoanDTO, Integer number) {
		super();
		this.ngaybl = ngaybl;
		this.mathangDTO = mathangDTO;
		this.taikhoanDTO = taikhoanDTO;
		this.number = number;
	}
	public Date getNgaybl() {
		return ngaybl;
	}
	
	public DanhgiaDTO() {
		super();
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
