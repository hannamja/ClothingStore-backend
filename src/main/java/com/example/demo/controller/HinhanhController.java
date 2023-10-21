package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HinhanhDTO;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.service.HinhanhService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class HinhanhController {
	@Autowired
	private HinhanhService hinhanhService;
	@Autowired
	private ModelMapper modelMapper;
	@RequestMapping("/hinhanh")
	public ResponseEntity<List<HinhanhDTO>> getAllHinhanh(){
		List<HinhanhDTO> hinhanhDTOs=hinhanhService.getAllHinhanh();
		if (hinhanhDTOs.isEmpty()) {
			return new ResponseEntity<List<HinhanhDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<HinhanhDTO>>(hinhanhDTOs,HttpStatus.OK);
	}
	@GetMapping("/hinhanh/{id}")
	public List<HinhanhDTO> getAll(@PathVariable int id){
		return hinhanhService.getHinhanhByMH(id);
	}
	@PostMapping("/hinhanh")
	public HinhanhDTO saveHinhanh(@RequestBody HinhanhDTO hinhanhDTO) {
		return hinhanhService.save(hinhanhDTO);
	}
	@PostMapping("/hinhanhs")
	public List<HinhanhDTO> saveAll(@RequestBody List<HinhanhDTO> hinhanhDTOs){
		
		return hinhanhService.saveAll(hinhanhDTOs);
	}
	
}
