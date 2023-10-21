package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhacungcap;

public interface NhacungcapRepository extends JpaRepository<Nhacungcap, Integer> {
	
}
