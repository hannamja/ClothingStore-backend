package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

}
