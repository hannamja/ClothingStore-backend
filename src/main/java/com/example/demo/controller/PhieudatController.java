package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.service.PhieudatService;
import com.example.demo.service.PhieunhapService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PhieudatController {
	@Autowired
	private PhieudatService phieudatService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/phieudat")
	public List<PhieudatDTO> getAllHoadon(){
		return phieudatService.getAllPhieudat();
	}
	@PostMapping("/phieudat")
	public PhieudatDTO save(@RequestBody PhieudatDTO phieudatDTO) {
		return phieudatService.save(phieudatDTO);
	}
	@GetMapping("/phieudat/{id}")
	public PhieudatDTO getById(@PathVariable int id) {
		return phieudatService.findById(id);
	}
	@DeleteMapping("/phieudat/{id}")
	public ApiResponse delete(@PathVariable int id) {
		return phieudatService.delete(id);
	}
}
