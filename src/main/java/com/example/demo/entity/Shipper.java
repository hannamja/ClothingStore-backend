package com.example.demo.entity;

import java.util.List;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="shipper")
public class Shipper {
	private String mashipper;
	private String tenshipper;
	private String diachi;
	private String sdt;
	
	public Shipper() {
		
	}

	public Shipper(String mashipper, String tenshipper) {
		super();
		this.mashipper = mashipper;
		this.tenshipper = tenshipper;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MASHIPPER")
	public String getMashipper() {
		return mashipper;
	}

	public void setMashipper(String mashipper) {
		this.mashipper = mashipper;
	}
	
	@Column(name = "TENSHIPPER")
	public String getTenshipper() {
		return tenshipper;
	}

	public void setTenshipper(String tenshipper) {
		this.tenshipper = tenshipper;
	}

	@Column(name = "DIACHI")
	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	@Column(name = "SDT")
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
	
}
