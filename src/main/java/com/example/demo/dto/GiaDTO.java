package com.example.demo.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class GiaDTO {
	private MathangDTO mathangDTO;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngayapdung;
	private NhanvienDTO nhanvienDTO;
	private Integer gia;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaykt; 
	
	public GiaDTO(MathangDTO mathangDTO, Date ngayapdung, NhanvienDTO nhanvienDTO, Integer gia, Date ngaykt) {
		super();
		this.mathangDTO = mathangDTO;
		this.ngayapdung = ngayapdung;
		this.nhanvienDTO = nhanvienDTO;
		this.gia = gia;
		this.ngaykt = ngaykt;
	}
	public GiaDTO() {
		super();
	}
	public MathangDTO getMathangDTO() {
		return mathangDTO;
	}
	public void setMathangDTO(MathangDTO mathangDTO) {
		this.mathangDTO = mathangDTO;
	}
	public Date getNgayapdung() {
		return ngayapdung;
	}
	public void setNgayapdung(Date ngayapdung) {
		this.ngayapdung = ngayapdung;
	}
	public NhanvienDTO getNhanvienDTO() {
		return nhanvienDTO;
	}
	public void setNhanvienDTO(NhanvienDTO nhanvienDTO) {
		this.nhanvienDTO = nhanvienDTO;
	}
	public Integer getGia() {
		return gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	public Date getNgaykt() {
		return ngaykt;
	}
	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}
	
	
}
