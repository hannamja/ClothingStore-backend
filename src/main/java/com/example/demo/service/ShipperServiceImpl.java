package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shipper;
import com.example.demo.repository.ShipperRepository;

@Service
public class ShipperServiceImpl implements ShipperService {
	@Autowired
	private ShipperRepository shipperRepository;

	@Override
	public List<Shipper> getAllShippers() {
		// TODO Auto-generated method stub
		return shipperRepository.findAll();
	}
	
	
}
