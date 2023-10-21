package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.Phieunhap;

public interface PhieunhapRepository extends JpaRepository<Phieunhap, Integer> {
	@Query(value = "CALL getPns(:MAPD);", nativeQuery = true)
    public List<Phieunhap> getPns(@Param("MAPD") Integer mapd);
}
