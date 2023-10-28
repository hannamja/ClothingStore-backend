package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ChatlieuDTO;
import com.example.demo.dto.NhanhieuDTO;
import com.example.demo.entity.Chatlieu;
import com.example.demo.entity.Nhanhieu;
import com.example.demo.service.NhanhieuService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NhanhieuController {
	@Autowired
	private NhanhieuService nhanhieuService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/nhanhieu")
	public ResponseEntity<List<NhanhieuDTO>> getAllNhanhieu(){
		List<NhanhieuDTO> nhanhieuDTOs=nhanhieuService.getAllNhanhieuMh();
		if (nhanhieuDTOs.isEmpty()) {
			return new ResponseEntity<List<NhanhieuDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NhanhieuDTO>>(nhanhieuDTOs,HttpStatus.OK);
	}
	@PostMapping("/nhanhieu")
	public NhanhieuDTO save(@RequestBody NhanhieuDTO nhanhieuDTO) {
		try {
			return nhanhieuService.save(modelMapper.map(nhanhieuDTO, Nhanhieu.class));
		}
		catch(Exception e) {
			return new NhanhieuDTO();
		}
	}
	@GetMapping("/nhanhieu/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Nhanhieu nhanhieu = nhanhieuService.getLoaimhById(id);
		if(nhanhieu==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Chất liệu khong ton tai",null));
		}
		return  new ResponseEntity<>(modelMapper.map(nhanhieu, NhanhieuDTO.class),HttpStatus.OK);
	}
	@DeleteMapping("/nhanhieu/{id}")
	public ResponseEntity<Object> save(@PathVariable int id) {
		return ResponseEntity.ok(nhanhieuService.delete(id));
	}
}
