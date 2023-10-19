package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HoadonDTO {
	private Integer mahd;
	private KhachhangDTO khachhang;
	private NhanvienDTO nhanvien;
	private ShipperDTO shipper;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ngaytao;
	private Integer tongtien;
	private String diachi;
	private ChitietTrangThaiDTO chitietTrangThaiDTO;
	private List<ChitietHoadonDTO> chitietHoadonDTO;
	
	

	public HoadonDTO(Integer mahd, KhachhangDTO khachhang, NhanvienDTO nhanvien, ShipperDTO shipper, Date ngaytao,
			Integer tongtien, String diachi, ChitietTrangThaiDTO chitietTrangThaiDTO,
			List<ChitietHoadonDTO> chitietHoadonDTO) {
		super();
		this.mahd = mahd;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.shipper = shipper;
		this.ngaytao = ngaytao;
		this.tongtien = tongtien;
		this.diachi = diachi;
		this.chitietTrangThaiDTO = chitietTrangThaiDTO;
		this.chitietHoadonDTO = chitietHoadonDTO;
	}



	public HoadonDTO() {
		super();
	}
	
	

	public HoadonDTO(Integer mahd) {
		super();
		this.mahd = mahd;
	}

	public List<ChitietHoadonDTO> getChitietHoadonDTO() {
		return chitietHoadonDTO;
	}

	public void setChitietHoadonDTO(List<ChitietHoadonDTO> chitietHoadonDTO) {
		this.chitietHoadonDTO = chitietHoadonDTO;
	}

	public ChitietTrangThaiDTO getChitietTrangThaiDTO() {
		return chitietTrangThaiDTO;
	}
	public void setChitietTrangThaiDTO(ChitietTrangThaiDTO chitietTrangThaiDTO) {
		this.chitietTrangThaiDTO = chitietTrangThaiDTO;
	}
	public Integer getMahd() {
		return mahd;
	}
	public void setMahd(Integer mahd) {
		this.mahd = mahd;
	}
	public KhachhangDTO getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachhangDTO khachhang) {
		this.khachhang = khachhang;
	}
	public NhanvienDTO getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanvienDTO nhanvien) {
		this.nhanvien = nhanvien;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public Integer getTongtien() {
		return tongtien;
	}
	public void setTongtien(Integer tongtien) {
		this.tongtien = tongtien;
	}

	public ShipperDTO getShipper() {
		return shipper;
	}

	public void setShipper(ShipperDTO shipper) {
		this.shipper = shipper;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	
}
