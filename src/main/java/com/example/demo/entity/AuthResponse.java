package com.example.demo.entity;

import java.util.List;

public class AuthResponse {
	private String email;
    private String accessToken;
    private Khachhang khachhang;
    private Nhanvien nhanvien;
    private int matk;
    private List<CtQuyen> ctQuyens;
    public AuthResponse() { }

	public AuthResponse(String email, String accessToken) {
		super();
		this.email = email;
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public AuthResponse(String email, String accessToken, List<CtQuyen> ctQuyens) {
		super();
		this.email = email;
		this.accessToken = accessToken;
		this.ctQuyens = ctQuyens;
	}

	public List<CtQuyen> getCtQuyens() {
		return ctQuyens;
	}

	public void setCtQuyens(List<CtQuyen> ctQuyens) {
		this.ctQuyens = ctQuyens;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public int getMatk() {
		return matk;
	}

	public void setMatk(int matk) {
		this.matk = matk;
	}

	

	
     
    
}
