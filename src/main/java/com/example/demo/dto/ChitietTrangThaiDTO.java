package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ChitietTrangThaiDTO {
	private HoadonDTO hoadonDTO;
	private TrangThaihdDTO trangthai;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaytao;
	
	public ChitietTrangThaiDTO(HoadonDTO hoadonDTO, TrangThaihdDTO trangthai, Date ngaytao) {
		super();
		this.hoadonDTO = hoadonDTO;
		this.trangthai = trangthai;
		this.ngaytao = ngaytao;
	}

	public ChitietTrangThaiDTO() {
		super();
	}
	
	public HoadonDTO getHoadonDTO() {
		return hoadonDTO;
	}
	public void setHoadonDTO(HoadonDTO hoadonDTO) {
		this.hoadonDTO = hoadonDTO;
	}
	
	

	public TrangThaihdDTO getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(TrangThaihdDTO trangthai) {
		this.trangthai = trangthai;
	}

	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	
}
