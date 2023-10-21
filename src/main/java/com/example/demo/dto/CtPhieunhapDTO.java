package com.example.demo.dto;

import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Phieunhap;

public class CtPhieunhapDTO {
	private CtPhieunhapIdDTO ctPhieunhapIdDTO;
	private ChitietMathangDTO ctMathangDTO;
	private ImportDTO phieunhapDTO;
	private Integer soluong;
	private Integer dongia;
	public CtPhieunhapDTO () {
		
	}
	public CtPhieunhapDTO(CtPhieunhapIdDTO ctPhieunhapIdDTO, ChitietMathangDTO ctMathangDTO, ImportDTO phieunhapDTO,
			Integer soluong, Integer dongia) {
		super();
		this.ctPhieunhapIdDTO = ctPhieunhapIdDTO;
		this.ctMathangDTO = ctMathangDTO;
		this.phieunhapDTO = phieunhapDTO;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	public CtPhieunhapIdDTO getCtPhieunhapIdDTO() {
		return ctPhieunhapIdDTO;
	}
	public void setCtPhieunhapIdDTO(CtPhieunhapIdDTO ctPhieunhapIdDTO) {
		this.ctPhieunhapIdDTO = ctPhieunhapIdDTO;
	}
	public ChitietMathangDTO getCtMathangDTO() {
		return ctMathangDTO;
	}
	public void setCtMathangDTO(ChitietMathangDTO ctMathangDTO) {
		this.ctMathangDTO = ctMathangDTO;
	}
	public ImportDTO getPhieunhapDTO() {
		return phieunhapDTO;
	}
	public void setPhieunhapDTO(ImportDTO phieunhapDTO) {
		this.phieunhapDTO = phieunhapDTO;
	}
	public Integer getSoluong() {
		return soluong;
	}
	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}
	public Integer getDongia() {
		return dongia;
	}
	public void setDongia(Integer dongia) {
		this.dongia = dongia;
	}
	
	
}
