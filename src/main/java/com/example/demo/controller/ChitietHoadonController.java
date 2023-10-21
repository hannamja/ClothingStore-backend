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

import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.service.ChitietHoadonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChitietHoadonController {
	@Autowired
	private ChitietHoadonService chitietHoadonService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/cthoadon")
	public List<ChitietHoadonDTO> getAllCthoadon(){
		return chitietHoadonService.getAllCtHoadon();
	}
	@GetMapping("/cthoadon/{mahd}")
	public List<ChitietHoadonDTO> getCthoadonByid(@PathVariable int mahd){
		return chitietHoadonService.getCtHoadonByHD(mahd);
	}
	@PostMapping("/cthoadon")
	public ChitietHoadonDTO saveCthoadon(@RequestBody ChitietHoadonDTO chitietHoadonDTO) {
		return chitietHoadonService.saveCthoadon(chitietHoadonDTO);
	}
	@PostMapping("/cthoadons")
	public List<ChitietHoadonDTO> saveCthoadonAll(@RequestBody List<ChitietHoadonDTO> chitietHoadonDTO) {
		return chitietHoadonService.saveCtHoadonAll(chitietHoadonDTO);
	}
}
