package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.CtQuyen;

public interface CtQuyenRepository extends JpaRepository<CtQuyen, Integer> {
	@Query(value = "CALL getCT_q(:MAQ);", nativeQuery = true)
    public List<CtQuyen> getCt_q(@Param("MAQ") Integer maq);
	@Query(value = "CALL getCT_q1(:MATK);", nativeQuery = true)
    public List<CtQuyen> getCt_q1(@Param("MATK") Integer matk);
}
