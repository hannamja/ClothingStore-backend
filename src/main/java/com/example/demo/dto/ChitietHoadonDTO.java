package com.example.demo.dto;

public class ChitietHoadonDTO {
	private HoadonDTO hoadonDTO;
	private ChitietMathangDTO chitietMathangDTO;
	private Integer soluong;
	private Integer gia;
	public ChitietHoadonDTO(HoadonDTO hoadonDTO, ChitietMathangDTO chitietMathangDTO, Integer soluong, Integer gia) {
		super();
		this.hoadonDTO = hoadonDTO;
		this.chitietMathangDTO = chitietMathangDTO;
		this.soluong = soluong;
		this.gia = gia;
	}
	public ChitietHoadonDTO() {
		super();
	}
	public HoadonDTO getHoadonDTO() {
		return hoadonDTO;
	}
	public void setHoadonDTO(HoadonDTO hoadonDTO) {
		this.hoadonDTO = hoadonDTO;
	}
	public ChitietMathangDTO getChitietMathangDTO() {
		return chitietMathangDTO;
	}
	public void setChitietMathangDTO(ChitietMathangDTO chitietMathangDTO) {
		this.chitietMathangDTO = chitietMathangDTO;
	}
	public Integer getSoluong() {
		return soluong;
	}
	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}
	public Integer getGia() {
		return gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	
}
