package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gia;

public interface GiaRepository extends JpaRepository<Gia, Integer>{
	@Query(value = "CALL getGia(:MAMH);", nativeQuery = true)
    public Gia getBanggiaLast(@Param("MAMH") Integer mamh);

}
