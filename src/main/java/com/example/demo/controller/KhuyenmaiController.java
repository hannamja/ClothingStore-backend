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

import com.example.demo.convert.Khuyenmaiconvert;
import com.example.demo.convert.QuyenConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.KhuyenmaiDTO;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.repository.CtKhuyenmaiRepository;
import com.example.demo.repository.KhuyenmaiRepository;
import com.example.demo.repository.QuyenRepository;
import com.example.demo.service.KhuyenmaiService;
import com.example.demo.service.QuyenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class KhuyenmaiController {
	@Autowired
	private KhuyenmaiService khuyenmaiService;
	@Autowired
	private KhuyenmaiRepository khuyenmaiRepository;
	@Autowired
	private CtKhuyenmaiRepository ctKhuyenmaiRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	Khuyenmaiconvert khuyenmaiconvert;
	@GetMapping("/km")
	public ResponseEntity<List<KhuyenmaiDTO>> getAllNhanhieu(){
		List<KhuyenmaiDTO> quyenDTOs=khuyenmaiService.getAll();
		return new ResponseEntity<List<KhuyenmaiDTO>>(quyenDTOs,HttpStatus.OK);
	}
	@PostMapping("/km")
	public KhuyenmaiDTO save(@RequestBody KhuyenmaiDTO kmDTO) {
		return khuyenmaiService.save(kmDTO);
	}
	@GetMapping("/km/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Khuyenmai km = khuyenmaiRepository.findById(id).get();
		if(km==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Chất liệu khong ton tai",null));
		}
		return  new ResponseEntity<>(khuyenmaiconvert.toDTO(km,ctKhuyenmaiRepository.getKhuyenmai1(id)),HttpStatus.OK);
	}
	
	@DeleteMapping("/km/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		return ResponseEntity.ok().body(khuyenmaiService.detele(id));
	}
}
