package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.Mathang;

public interface MathangRepository extends JpaRepository<Mathang, Integer> {
	@Query(value = "CALL getMathangByNh(:MANH);", nativeQuery = true)
    public List<Mathang> getMathangByNh(@Param("MANH") Integer manh);
	@Query(value = "CALL getMathangByLoai(:MALOAI);", nativeQuery = true)
    public List<Mathang> getMathangByLoai(@Param("MALOAI") Integer maloai);
	@Query(value = "CALL getMathangByCl(:MACL);", nativeQuery = true)
    public List<Mathang> getMathangByCl(@Param("MACL") Integer macl);
	@Query(value = "CALL getMathangByName(:NAME);", nativeQuery = true)
    public List<Mathang> getMathangByName(@Param("NAME") String name);
}
