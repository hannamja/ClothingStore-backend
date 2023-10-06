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

import com.example.demo.dto.BinhluanDTO;
import com.example.demo.dto.DanhgiaDTO;
import com.example.demo.service.BinhluanService;
import com.example.demo.service.DanhgiaService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DanhgiaController {
	@Autowired
	private DanhgiaService danhgiaService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/danhgia")
	public List<DanhgiaDTO> getAllDanhgia(){
		return danhgiaService.getAllDanhgia();
	}
	@PostMapping("/danhgia")
	public DanhgiaDTO save(@RequestBody DanhgiaDTO danhgiaDTO) {
		return danhgiaService.save(danhgiaDTO);
	}
}
