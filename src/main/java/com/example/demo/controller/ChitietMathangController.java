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

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.service.ChitietMathangService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChitietMathangController {
	@Autowired
	private ChitietMathangService chitietMathangService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/ctmathang")
	public List<ChitietMathangDTO> getAll(){
		return chitietMathangService.getAllCtMathang();
	}
	@GetMapping("/ctmathang/{id}")
	public List<ChitietMathangDTO> getCtMathangByMH(@PathVariable int id){
		return chitietMathangService.getCtMathang(id);
	}
	@PostMapping("/ctmathang")
	public ChitietMathangDTO saveCtmathang(@RequestBody ChitietMathangDTO chitietMathangDTO) {
		return chitietMathangService.saveCtMathang(chitietMathangDTO);
	}
}
