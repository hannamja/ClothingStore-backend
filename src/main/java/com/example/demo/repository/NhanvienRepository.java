package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nhanvien;

public interface NhanvienRepository extends JpaRepository<Nhanvien, Integer> {

}
