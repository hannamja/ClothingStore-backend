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
import com.example.demo.service.BinhluanService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BinhluanController {
	@Autowired
	private BinhluanService binhluanService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/binhluan")
	public List<BinhluanDTO> getAllBinhluan(){
		return binhluanService.getAllBinhluan();
	}
	@PostMapping("/binhluan")
	public BinhluanDTO saveBinhluan(@RequestBody BinhluanDTO binhluanDTO) {
		return binhluanService.saveBinhluan(binhluanDTO);
	}
}
