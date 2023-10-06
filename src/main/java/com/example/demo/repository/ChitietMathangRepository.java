package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Hinhanhmh;

public interface ChitietMathangRepository extends JpaRepository<CtMathang, Integer> {
	@Query(value = "CALL getSoluong(:MAMH);", nativeQuery = true)
    public List<CtMathang> getCTMathang(@Param("MAMH") Integer mamh);
}
