package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quyen;

@Service
public interface QuyenRepository extends JpaRepository<Quyen, Integer> {

}
