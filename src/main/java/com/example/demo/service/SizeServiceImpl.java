package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Size;
import com.example.demo.repository.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService {
	@Autowired
	private SizeRepository sizeRepository;
	@Override
	public List<Size> getSizes() {
		return sizeRepository.findAll();
	}
}
