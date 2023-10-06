package com.example.demo.dto;

import lombok.Data;

@Data
public class CtPhieunhapIdDTO {
	private Integer mapn;
	private Integer id;
	
	public CtPhieunhapIdDTO() {
		
	}

	public CtPhieunhapIdDTO(Integer mapn, Integer id) {
		super();
		this.mapn = mapn;
		this.id = id;
	}

	public Integer getMapn() {
		return mapn;
	}

	public void setMapn(Integer mapn) {
		this.mapn = mapn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
