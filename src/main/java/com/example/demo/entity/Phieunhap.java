package com.example.demo.entity;
// Generated Jul 11, 2023, 9:57:41 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Phieunhap generated by hbm2java
 */
@Entity
@Table(name = "phieunhap")
public class Phieunhap implements java.io.Serializable {

	private Integer mapn;
	private Nhanvien nhanvien;
	private Phieudat phieudat;
	private Date ngaynhap;
	private Set<CtPhieunhap> ctPhieunhaps = new HashSet<CtPhieunhap>(0);

	public Phieunhap() {
	}

	public Phieunhap(Integer mapn) {
		super();
		this.mapn = mapn;
	}

	public Phieunhap(Nhanvien nhanvien, Phieudat phieudat, Date ngaynhap, Set<CtPhieunhap> ctPhieunhaps) {
		this.nhanvien = nhanvien;
		this.phieudat = phieudat;
		this.ngaynhap = ngaynhap;
		this.ctPhieunhaps = ctPhieunhaps;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MAPN", unique = true, nullable = false)
	public Integer getMapn() {
		return this.mapn;
	}

	public void setMapn(Integer mapn) {
		this.mapn = mapn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANV")
	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAPD")
	public Phieudat getPhieudat() {
		return this.phieudat;
	}

	public void setPhieudat(Phieudat phieudat) {
		this.phieudat = phieudat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NGAYNHAP", length = 10)
	public Date getNgaynhap() {
		return this.ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phieunhap")
	public Set<CtPhieunhap> getCtPhieunhaps() {
		return this.ctPhieunhaps;
	}

	public void setCtPhieunhaps(Set<CtPhieunhap> ctPhieunhaps) {
		this.ctPhieunhaps = ctPhieunhaps;
	}

}
