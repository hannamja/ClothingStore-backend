package com.example.demo.dto;

import com.example.demo.entity.Mathang;

public class ChitietMathangDTO {
	private Integer id;
	private String color;
	private String size;
	private String currentNumbeer;
	private MathangDTO mathangDTO;
	
	public ChitietMathangDTO(Integer id, String color, String size, String currentNumbeer, MathangDTO mathangDTO) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
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
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCurrentNumbeer() {
		return currentNumbeer;
	}
	public void setCurrentNumbeer(String currentNumbeer) {
		this.currentNumbeer = currentNumbeer;
	}
	
}
