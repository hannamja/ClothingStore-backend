package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtTrangthai;
import com.example.demo.entity.CtTrangthaiId;

public interface ChitietTrangThaiRepository extends JpaRepository<CtTrangthai, CtTrangthaiId>{
	@Query(value = "CALL getCT_TrangThai(:MAHD);", nativeQuery = true)
    public CtTrangthai getCT_TrangThai(@Param("MAHD") Integer mahd);
}
