package com.example.demo.entity;
// Generated Jul 11, 2023, 9:57:41 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CtTrangthaiId generated by hbm2java
 */
@Embeddable
public class CtTrangthaiId implements java.io.Serializable {

	private int mahd;
	private int matthd;

	public CtTrangthaiId() {
	}

	public CtTrangthaiId(int mahd, int matthd) {
		this.mahd = mahd;
		this.matthd = matthd;
	}

	@Column(name = "MAHD", nullable = false)
	public int getMahd() {
		return this.mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	@Column(name = "MATTHD", nullable = false)
	public int getMatthd() {
		return this.matthd;
	}

	public void setMatthd(int matthd) {
		this.matthd = matthd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CtTrangthaiId))
			return false;
		CtTrangthaiId castOther = (CtTrangthaiId) other;

		return (this.getMahd() == castOther.getMahd()) && (this.getMatthd() == castOther.getMatthd());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMahd();
		result = 37 * result + this.getMatthd();
		return result;
	}

}
