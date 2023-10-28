package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.entity.Loaimh;
import com.example.demo.service.LoaimhService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LoaimhController {
	@Autowired
	private LoaimhService loaimhService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/loaimh")
	public ResponseEntity<List<LoaimhDTO>> getAllLoaimh(){
		List<LoaimhDTO> loaimhDTOs=loaimhService.getAllLoaiMH();
		if (loaimhDTOs.isEmpty()) {
			return new ResponseEntity<List<LoaimhDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<LoaimhDTO>>(loaimhDTOs,HttpStatus.OK);
	}
	@GetMapping("/loaimh/{id}")
	public ResponseEntity<Object> getLoaimhById(@PathVariable int id){
		Loaimh loaimh=loaimhService.getLoaimhById(id);
		if (loaimh==null) {
			//System.out.println(loaimh);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Loai mat hang khong ton tai",null));
		}
		return  new ResponseEntity<>(modelMapper.map(loaimh, LoaimhDTO.class),HttpStatus.OK);
	}
	@PostMapping("/loaimh")
	public ResponseEntity<Object> saveLoaimh(@RequestBody LoaimhDTO loaimhDTO){
		try {
			Loaimh loaimh=modelMapper.map(loaimhDTO, Loaimh.class);
			LoaimhDTO loaimhDTO2=loaimhService.save(loaimh);
			return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(),"Mat hang them thanh cong",loaimhDTO2));
		}
		catch(Exception e) {
			return ResponseEntity.ok(new ApiResponse(404,"",new LoaimhDTO()));
		}
	}
	@PutMapping("/loaimh/{id}")
	public ResponseEntity<Object> updateLoaimh(@RequestBody LoaimhDTO loaimhDTO,@PathVariable int id){
		Loaimh laLoaimh=loaimhService.getLoaimhById(id);
		if (laLoaimh==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Loai mat hang khong ton tai",null));
		}
		loaimhDTO.setMaloaimh(id);
		Loaimh loaimh=modelMapper.map(loaimhDTO, Loaimh.class);
		LoaimhDTO loaimhDTO2=loaimhService.save(loaimh);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Loai mat hang updated successfully ", loaimhDTO2));
	}
	@DeleteMapping("/loaimh/{id}")
	public ResponseEntity<Object> deleteLoaimh(@PathVariable int id){
		Loaimh loaimh=loaimhService.getLoaimhById(id);
		if (loaimh ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Loai mat hang khong ton tai",null));
		}
		
		return ResponseEntity.ok(loaimhService.delete(id));
		
	}
}
