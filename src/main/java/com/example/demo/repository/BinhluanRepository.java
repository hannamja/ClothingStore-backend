package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Binhluan;
import com.example.demo.entity.CtHoadon;

public interface BinhluanRepository extends JpaRepository<Binhluan, Integer>{
	@Query(value = "CALL getBinhluan(:MATK);", nativeQuery = true)
    public List<Binhluan> getBinhluan(@Param("MATK") Integer matk);
}
