package com.example.demo.dto;

public class CtPhieudatIdDTO {
	private Integer id;
	private Integer mapd;
	
	public CtPhieudatIdDTO() {
		
	}
	public CtPhieudatIdDTO(Integer id, Integer mapd) {
		super();
		this.id = id;
		this.mapd = mapd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMapd() {
		return mapd;
	}
	public void setMapd(Integer mapd) {
		this.mapd = mapd;
	}
	
	
}
