package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Nhanvien;

@Component
public class KhuyenmaiDTO {
	private Integer makm;
	private NhanvienDTO nhanvienDTO;
	private String lydo;
	private Date ngaybd;
	private Date ngaykt;
	private List<CtKhuyenmaiDTO> ctKhuyenmais;
	
	public KhuyenmaiDTO() {
		super();
	}

	
	
	public KhuyenmaiDTO(Integer makm, NhanvienDTO nhanvienDTO, String lydo, Date ngaybd, Date ngaykt,
			List<CtKhuyenmaiDTO> ctKhuyenmais) {
		super();
		this.makm = makm;
		this.nhanvienDTO = nhanvienDTO;
		this.lydo = lydo;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
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



	public NhanvienDTO getNhanvienDTO() {
		return nhanvienDTO;
	}



	public void setNhanvienDTO(NhanvienDTO nhanvienDTO) {
		this.nhanvienDTO = nhanvienDTO;
	}



	public Date getNgaybd() {
		return ngaybd;
	}



	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}



	public Date getNgaykt() {
		return ngaykt;
	}



	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}
	
	
}
