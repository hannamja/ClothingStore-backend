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

import com.example.demo.convert.QuyenConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtQuyenDTO;
import com.example.demo.entity.Taikhoan;
import com.example.demo.repository.QuyenRepository;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.CtQuyenService;
import com.example.demo.service.QuyenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CtQuyenController {
	@Autowired
	private QuyenService quyenService;
	@Autowired
	private QuyenRepository quyenRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private QuyenConvert convert;
	@Autowired
	private CtQuyenService ctQuyenService;
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	
	@GetMapping("/ctquyen/{id}")
	public List<CtQuyenDTO> getCtQ(@PathVariable  String id) {
		Taikhoan tk = taiKhoanRepository.findByEmail(id);
		return ctQuyenService.getCtQuyen(tk.getMatk());
	}
	
	@PostMapping("/ctquyen/{id}")
	public ApiResponse save(@RequestBody List<CtQuyenDTO> ctqDTO, @PathVariable String id) {
		Taikhoan tk = taiKhoanRepository.findByEmail(id);
		
		return ctQuyenService.save(ctqDTO, tk.getMatk());
	}

}
