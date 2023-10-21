package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.CtPhieunhap;

public interface CtPhieudatRepository extends JpaRepository<CtPhieudat, Integer> {
	@Query(value = "CALL getCT_Pd(:MAPD);", nativeQuery = true)
    public List<CtPhieudat> getCT_Pd(@Param("MAPD") Integer mapd);
}
