package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtQuyenDTO;

public interface CtQuyenService {
	List<CtQuyenDTO> getCtQuyen(Integer id);
	ApiResponse save(List<CtQuyenDTO> ctqDTOs,Integer tk);
}
