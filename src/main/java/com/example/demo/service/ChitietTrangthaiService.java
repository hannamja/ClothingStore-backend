package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChitietTrangThaiDTO;

public interface ChitietTrangthaiService {
	ChitietTrangThaiDTO getTrangThaibyHD(Integer mahd);
	List<ChitietTrangThaiDTO> getAllTrangThai();
	
}
