package com.example.demo.dto;

public class ShipperDTO {
	private String mashipper;
	private String tenshipper;
	private String diachi;
	private String sdt;
	
	public ShipperDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShipperDTO(String mashipper, String tenshipper, String diachi, String sdt) {
		super();
		this.mashipper = mashipper;
		this.tenshipper = tenshipper;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public String getMashipper() {
		return mashipper;
	}

	public void setMashipper(String mashipper) {
		this.mashipper = mashipper;
	}

	public String getTenshipper() {
		return tenshipper;
	}

	public void setTenshipper(String tenshipper) {
		this.tenshipper = tenshipper;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
