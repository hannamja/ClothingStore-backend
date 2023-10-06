package com.example.demo.dto;

import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtPhieudatId;
import com.example.demo.entity.Phieudat;

public class CtPhieudatDTO {
	private ChitietMathangDTO ctMathangDTOs;
	private PhieudatDTO phieudatDTO;
	private String soluong;
	private String dongia;
	public CtPhieudatDTO() {
		super();
	}
	
	
	public CtPhieudatDTO(ChitietMathangDTO ctMathangDTOs, PhieudatDTO phieudatDTO,
			String soluong, String dongia) {
		super();
		this.ctMathangDTOs = ctMathangDTOs;
		this.phieudatDTO = phieudatDTO;
		this.soluong = soluong;
		this.dongia = dongia;
	}


	

	public ChitietMathangDTO getCtMathangDTOs() {
		return ctMathangDTOs;
	}
	public void setCtMathangDTOs(ChitietMathangDTO ctMathangDTOs) {
		this.ctMathangDTOs = ctMathangDTOs;
	}
	public PhieudatDTO getPhieudatDTO() {
		return phieudatDTO;
	}
	public void setPhieudatDTO(PhieudatDTO phieudatDTO) {
		this.phieudatDTO = phieudatDTO;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	
	
}
