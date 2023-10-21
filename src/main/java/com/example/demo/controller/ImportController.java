package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.service.HoadonService;
import com.example.demo.service.PhieunhapService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ImportController {
	@Autowired
	private PhieunhapService phieunhapService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/phieunhap")
	public List<ImportDTO> getAllHoadon(){
		return phieunhapService.getAllPhieunhap();
	}
	@PostMapping("/phieunhap")
	public ImportDTO save(@RequestBody ImportDTO phieunhapDTO) {
		return phieunhapService.save(phieunhapDTO);
	}
	@GetMapping("/phieunhap/{id}")
	public ImportDTO getById(@PathVariable int id) {
		return phieunhapService.findById(id);
	}
}
