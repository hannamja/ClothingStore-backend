package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChitietMathangDTO;

public interface ChitietMathangService {
	List<ChitietMathangDTO> getAllCtMathang();
	ChitietMathangDTO saveCtMathang(ChitietMathangDTO chitietMathangDTO);
	List<ChitietMathangDTO> getCtMathang(Integer mamh);
}
