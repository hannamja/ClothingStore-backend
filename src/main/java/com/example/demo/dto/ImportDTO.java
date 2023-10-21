package com.example.demo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.entity.CtPhieunhap;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Phieudat;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ImportDTO {
	private Integer mapn;
	private NhanvienDTO nhanvienDTO;
	private PhieudatDTO phieudatDTO;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaynhap;
	private List<CtPhieunhapDTO> ctPhieunhapDTOs;

	public ImportDTO () {
		
	}

	public ImportDTO(Integer mapn) {
		super();
		this.mapn = mapn;
	}

	public ImportDTO(Integer mapn, NhanvienDTO nhanvienDTO, PhieudatDTO phieudatDTO, Date ngaynhap,
			List<CtPhieunhapDTO> ctPhieunhapDTOs) {
		super();
		this.mapn = mapn;
		this.nhanvienDTO = nhanvienDTO;
		this.phieudatDTO = phieudatDTO;
		this.ngaynhap = ngaynhap;
		this.ctPhieunhapDTOs = ctPhieunhapDTOs;
	}

	public Integer getMapn() {
		return mapn;
	}

	public void setMapn(Integer mapn) {
		this.mapn = mapn;
	}

	public NhanvienDTO getNhanvienDTO() {
		return nhanvienDTO;
	}

	public void setNhanvienDTO(NhanvienDTO nhanvienDTO) {
		this.nhanvienDTO = nhanvienDTO;
	}

	public PhieudatDTO getPhieudatDTO() {
		return phieudatDTO;
	}

	public void setPhieudatDTO(PhieudatDTO phieudatDTO) {
		this.phieudatDTO = phieudatDTO;
	}

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public List<CtPhieunhapDTO> getCtPhieunhapDTOs() {
		return ctPhieunhapDTOs;
	}

	public void setCtPhieunhapDTOs(List<CtPhieunhapDTO> ctPhieunhapDTOs) {
		this.ctPhieunhapDTOs = ctPhieunhapDTOs;
	}
	
	
}
