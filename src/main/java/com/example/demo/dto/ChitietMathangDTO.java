package com.example.demo.dto;


import com.example.demo.entity.Mathang;

public class ChitietMathangDTO {
	private Integer id;
	private ColorDTO colorDTO;
	private SizeDTO sizeDTO;
	private String currentNumbeer;
	private MathangDTO mathangDTO;
	
	public ChitietMathangDTO(Integer id, ColorDTO color, SizeDTO size, String currentNumbeer, MathangDTO mathangDTO) {
		super();
		this.id = id;
		this.colorDTO = color;
		this.sizeDTO = size;
		this.currentNumbeer = currentNumbeer;
		this.mathangDTO = mathangDTO;
	}
	public MathangDTO getMathangDTO() {
		return mathangDTO;
	}
	public void setMathangDTO(MathangDTO mathangDTO) {
		this.mathangDTO = mathangDTO;
	}
	public ChitietMathangDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ColorDTO getColorDTO() {
		return colorDTO;
	}
	public void setColorDTO(ColorDTO color) {
		this.colorDTO = color;
	}
	public SizeDTO getSizeDTO() {
		return sizeDTO;
	}
	public void setSizeDTO(SizeDTO size) {
		this.sizeDTO = size;
	}
	public String getCurrentNumbeer() {
		return currentNumbeer;
	}
	public void setCurrentNumbeer(String currentNumbeer) {
		this.currentNumbeer = currentNumbeer;
	}
	
}
