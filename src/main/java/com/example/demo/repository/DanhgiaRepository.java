package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.Danhgia;

public interface DanhgiaRepository extends JpaRepository<Danhgia, Integer> {
	@Query(value = "CALL getDanhgia(:MATK);", nativeQuery = true)
    public List<Danhgia> getDanhgia(@Param("MATK") Integer matk);
}
