package com.example.demo.entity;
// Generated Jul 11, 2023, 9:57:41 PM by Hibernate Tools 4.3.5.Final

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

/**
 * Khuyenmai generated by hbm2java
 */
@Entity
@Table(name = "khuyenmai")
public class Khuyenmai implements java.io.Serializable {

	private Integer makm;
	private Nhanvien nhanvien;
	private String lydo;
	private Set<CtKhuyenmai> ctKhuyenmais = new HashSet<CtKhuyenmai>(0);

	public Khuyenmai() {
	}

	public Khuyenmai(Nhanvien nhanvien, String lydo, Set<CtKhuyenmai> ctKhuyenmais) {
		this.nhanvien = nhanvien;
		this.lydo = lydo;
		this.ctKhuyenmais = ctKhuyenmais;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MAKM", unique = true, nullable = false)
	public Integer getMakm() {
		return this.makm;
	}

	public void setMakm(Integer makm) {
		this.makm = makm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANV")
	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	@Column(name = "LYDO", length = 45)
	public String getLydo() {
		return this.lydo;
	}

	public void setLydo(String lydo) {
		this.lydo = lydo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khuyenmai")
	public Set<CtKhuyenmai> getCtKhuyenmais() {
		return this.ctKhuyenmais;
	}

	public void setCtKhuyenmais(Set<CtKhuyenmai> ctKhuyenmais) {
		this.ctKhuyenmais = ctKhuyenmais;
	}

}
