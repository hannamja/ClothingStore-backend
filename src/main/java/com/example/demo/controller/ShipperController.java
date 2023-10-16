package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Shipper;
import com.example.demo.service.ShipperService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ShipperController {
	@Autowired
	private ShipperService shipperService;
	
	@GetMapping("/shipper")
	public List<Shipper> getAllShippers() {
		return shipperService.getAllShippers();
	}
}
