package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChitietTrangThaiDTO;
import com.example.demo.service.ChitietTrangthaiService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChitietTrangThaiController {
	@Autowired
	private ChitietTrangthaiService  chitietTrangthaiService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/cttrangthai/{id}")
	public ChitietTrangThaiDTO getAll(@PathVariable int id){
		return chitietTrangthaiService.getTrangThaibyHD(id);
	}
	@GetMapping("/cttrangthai")
	public List<ChitietTrangThaiDTO> getAll() {
		return chitietTrangthaiService.getAllTrangThai();
	}
	
}
