package com.example.demo.dto;

import com.example.demo.entity.Mathang;

import lombok.Data;

@Data
public class HinhanhDTO {
	private Integer maha;
	private String duongdan;
	private MathangDTO mathangDTO;
	public HinhanhDTO() {
		super();
	}
	
	public HinhanhDTO(Integer maha, String duongdan, MathangDTO mathangDTO) {
		super();
		this.maha = maha;
		this.duongdan = duongdan;
		this.mathangDTO = mathangDTO;
	}
	
	public HinhanhDTO(Integer maha, String duongdan) {
		super();
		this.maha = maha;
		this.duongdan = duongdan;
	}

	public MathangDTO getMathangDTO() {
		return mathangDTO;
	}

	public void setMathangDTO(MathangDTO mathangDTO) {
		this.mathangDTO = mathangDTO;
	}

	public Integer getMaha() {
		return maha;
	}
	public void setMaha(Integer maha) {
		this.maha = maha;
	}
	public String getDuongdan() {
		return duongdan;
	}
	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}
	
}
