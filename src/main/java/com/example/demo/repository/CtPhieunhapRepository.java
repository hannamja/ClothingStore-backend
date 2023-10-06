package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtPhieunhap;

public interface CtPhieunhapRepository extends JpaRepository<CtPhieunhap, Integer> {
	@Query(value = "CALL getCT_Pn(:MAPN);", nativeQuery = true)
    public List<CtPhieunhap> getCT_Pn(@Param("MAPN") Integer mapn);
}
