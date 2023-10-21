package com.example.demo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.Nhacungcap;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Phieunhap;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PhieudatDTO {
	private Integer mapd;
	private NhacungcapDTO nhacungcapDTO;
	private NhanvienDTO nhanvienDTO;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaydat;
	private List<ImportDTO> phieunhapDTOs;
	private List<CtPhieudatDTO> ctPhieudatDTOs;
	public PhieudatDTO() {
		super();
	}
	
	public PhieudatDTO(Integer mapd) {
		super();
		this.mapd = mapd;
	}

	public PhieudatDTO(Integer mapd, Date ngaydat) {
		super();
		this.mapd = mapd;
		this.ngaydat = ngaydat;
	}

	public PhieudatDTO(Integer mapd, NhacungcapDTO nhacungcapDTO, NhanvienDTO nhanvienDTO, Date ngaydat,
			List<ImportDTO> phieunhapDTOs, List<CtPhieudatDTO> ctPhieudatDTOs) {
		super();
		this.mapd = mapd;
		this.nhacungcapDTO = nhacungcapDTO;
		this.nhanvienDTO = nhanvienDTO;
		this.ngaydat = ngaydat;
		this.phieunhapDTOs = phieunhapDTOs;
		this.ctPhieudatDTOs = ctPhieudatDTOs;
	}

	public Integer getMapd() {
		return mapd;
	}

	public void setMapd(Integer mapd) {
		this.mapd = mapd;
	}

	public NhacungcapDTO getNhacungcapDTO() {
		return nhacungcapDTO;
	}

	public void setNhacungcapDTO(NhacungcapDTO nhacungcapDTO) {
		this.nhacungcapDTO = nhacungcapDTO;
	}

	public NhanvienDTO getNhanvienDTO() {
		return nhanvienDTO;
	}

	public void setNhanvienDTO(NhanvienDTO nhanvienDTO) {
		this.nhanvienDTO = nhanvienDTO;
	}

	public Date getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public List<ImportDTO> getPhieunhapDTOs() {
		return phieunhapDTOs;
	}

	public void setPhieunhapDTOs(List<ImportDTO> phieunhapDTOs) {
		this.phieunhapDTOs = phieunhapDTOs;
	}

	public List<CtPhieudatDTO> getCtPhieudatDTOs() {
		return ctPhieudatDTOs;
	}

	public void setCtPhieudatDTOs(List<CtPhieudatDTO> ctPhieudatDTOs) {
		this.ctPhieudatDTOs = ctPhieudatDTOs;
	}

	
	
}
