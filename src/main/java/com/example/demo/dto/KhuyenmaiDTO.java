package com.example.demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Nhanvien;

@Component
public class KhuyenmaiDTO {
	private Integer makm;
	private NhanvienDTO nhanvienDTO;
	private String lydo;
	private List<CtKhuyenmaiDTO> ctKhuyenmais;
	
	public KhuyenmaiDTO() {
		super();
	}
	public KhuyenmaiDTO(Integer makm, NhanvienDTO nhanvien, String lydo, List<CtKhuyenmaiDTO> ctKhuyenmais) {
		super();
		this.makm = makm;
		this.nhanvienDTO = nhanvien;
		this.lydo = lydo;
		this.ctKhuyenmais = ctKhuyenmais;
	}
	public Integer getMakm() {
		return makm;
	}
	public void setMakm(Integer makm) {
		this.makm = makm;
	}
	public NhanvienDTO getNhanvien() {
		return nhanvienDTO;
	}
	public void setNhanvien(NhanvienDTO nhanvien) {
		this.nhanvienDTO = nhanvien;
	}
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	public List<CtKhuyenmaiDTO> getCtKhuyenmais() {
		return ctKhuyenmais;
	}
	public void setCtKhuyenmais(List<CtKhuyenmaiDTO> ctKhuyenmais) {
		this.ctKhuyenmais = ctKhuyenmais;
	}
}
