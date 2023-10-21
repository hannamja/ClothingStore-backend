package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BinhluanDTO;
import com.example.demo.dto.DanhgiaDTO;

public interface DanhgiaService {
	List<DanhgiaDTO> getAllDanhgia();
	DanhgiaDTO save(DanhgiaDTO danhgiaDTO);
}
