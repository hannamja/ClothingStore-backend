package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Phieudat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhacungcap;

public interface NhacungcapRepository extends JpaRepository<Nhacungcap, Integer> {
	@Query(value = "CALL getNccBySdt(:EMAIL);", nativeQuery = true)
	public List<Phieudat> getNccByEmail(@Param("EMAIL") String email);
	@Query(value = "CALL getNccBySdt(:SDT);", nativeQuery = true)
	public List<Phieudat> getNccBySdt(@Param("SDT") String sdt);
}
