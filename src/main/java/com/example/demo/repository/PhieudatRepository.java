package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Nhacungcap;
import com.example.demo.entity.Phieudat;

public interface PhieudatRepository extends JpaRepository<Phieudat, Integer> {
	@Query(value = "CALL getMathangByCl(:MANCC);", nativeQuery = true)
    public List<Phieudat> getPdByNcc(@Param("MANCC") Integer mancc);
}
