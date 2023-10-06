package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GiaDTO;
import com.example.demo.entity.Gia;

public interface GiaService {
	GiaDTO save(GiaDTO giaDTO);
	List<GiaDTO> getAllGia();
}
