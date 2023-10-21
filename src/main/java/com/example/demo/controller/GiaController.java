package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GiaDTO;
import com.example.demo.entity.Gia;
import com.example.demo.service.GiaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GiaController {
	@Autowired
	private GiaService giaService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/gia")
	public List<GiaDTO> getAllGia(){
		return giaService.getAllGia();
	}
	@PostMapping("/gia")
	public GiaDTO saveGiaDTO(@RequestBody GiaDTO giaDTO) {
		return giaService.save(giaDTO);
	}
}
