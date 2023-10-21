package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.entity.Loaimh;

public interface LoaimhService {
	List<LoaimhDTO> getAllLoaiMH();
	Loaimh getLoaimhById(Integer id);
	LoaimhDTO save(Loaimh loaimh);
	ApiResponse delete(Integer id);
}
