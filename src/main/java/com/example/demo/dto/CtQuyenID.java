package com.example.demo.dto;

import java.util.Date;

public class CtQuyenID {
	private Date ngaystart;
	private int maquyen;
	private int matk;
	
	public CtQuyenID() {
		super();
	}
	public CtQuyenID(Date ngaystart, int maquyen, int matk) {
		super();
		this.ngaystart = ngaystart;
		this.maquyen = maquyen;
		this.matk = matk;
	}
	public Date getNgaystart() {
		return ngaystart;
	}
	public void setNgaystart(Date ngaystart) {
		this.ngaystart = ngaystart;
	}
	public int getMaquyen() {
		return maquyen;
	}
	public void setMaquyen(int maquyen) {
		this.maquyen = maquyen;
	}
	public int getMatk() {
		return matk;
	}
	public void setMatk(int matk) {
		this.matk = matk;
	}
	
}
