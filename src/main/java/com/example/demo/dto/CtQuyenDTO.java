package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.CtQuyenId;
import com.example.demo.entity.Quyen;
import com.example.demo.entity.Taikhoan;

public class CtQuyenDTO {
	private CtQuyenID id;
	private QuyenDTO quyen;
	private TaikhoanDTO taikhoan;
	private Date ngayend;
	
	public CtQuyenDTO() {
		super();
	}

	public CtQuyenDTO(CtQuyenID id, QuyenDTO quyen, TaikhoanDTO taikhoan, Date ngayend) {
		super();
		this.id = id;
		this.quyen = quyen;
		this.taikhoan = taikhoan;
		this.ngayend = ngayend;
	}

	public CtQuyenID getId() {
		return id;
	}

	public void setId(CtQuyenID id) {
		this.id = id;
	}

	public QuyenDTO getQuyen() {
		return quyen;
	}

	public void setQuyen(QuyenDTO quyen) {
		this.quyen = quyen;
	}

	public TaikhoanDTO getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaikhoanDTO taikhoan) {
		this.taikhoan = taikhoan;
	}

	public Date getNgayend() {
		return ngayend;
	}

	public void setNgayend(Date ngayend) {
		this.ngayend = ngayend;
	}

	

	
}
