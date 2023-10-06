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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.QuyenConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.NhanhieuDTO;
import com.example.demo.dto.QuyenDTO;
import com.example.demo.entity.Nhanhieu;
import com.example.demo.entity.Quyen;
import com.example.demo.repository.QuyenRepository;
import com.example.demo.service.QuyenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class QuyenController {
	@Autowired
	private QuyenService quyenService;
	@Autowired
	private QuyenRepository quyenRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	QuyenConvert convert;
	@GetMapping("/role")
	public ResponseEntity<List<QuyenDTO>> getAllNhanhieu(){
		List<QuyenDTO> quyenDTOs=quyenService.getAll();
		if (quyenDTOs.isEmpty()) {
			return new ResponseEntity<List<QuyenDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<QuyenDTO>>(quyenDTOs,HttpStatus.OK);
	}
	@PostMapping("/role")
	public QuyenDTO save(@RequestBody QuyenDTO quyenDTO) {
		return quyenService.save(quyenDTO);
	}
	@GetMapping("/role/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Quyen quyen = quyenRepository.findById(id).get();
		if(quyen==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Chất liệu khong ton tai",null));
		}
		return  new ResponseEntity<>(convert.toDTO(quyen),HttpStatus.OK);
	}
	@DeleteMapping("/role/{id}")
	public ApiResponse delete(@PathVariable int id) {
		return quyenService.delete(id);
	}
}
