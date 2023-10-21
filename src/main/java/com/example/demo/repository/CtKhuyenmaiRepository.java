package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtKhuyenmai;

public interface CtKhuyenmaiRepository extends JpaRepository<CtKhuyenmai,Integer> {
	@Query(value = "CALL getKhuyenmai(:MAMH);", nativeQuery = true)
    public List<CtKhuyenmai> getKhuyenmai(@Param("MAMH") Integer mamh);
	@Query(value = "CALL getKhuyenmai1(:MAKM);", nativeQuery = true)
    public List<CtKhuyenmai> getKhuyenmai1(@Param("MAKM") Integer makm);
}
