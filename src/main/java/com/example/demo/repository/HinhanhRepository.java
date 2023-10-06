package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gia;
import com.example.demo.entity.Hinhanhmh;

public interface HinhanhRepository extends JpaRepository<Hinhanhmh, Integer> {
	@Query(value = "CALL getHAByMH(:MAMH);", nativeQuery = true)
    public List<Hinhanhmh> getHAByMH(@Param("MAMH") Integer mamh);
}
