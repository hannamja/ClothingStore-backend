package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.QuyenDTO;
import com.example.demo.entity.Quyen;
@Service
public interface QuyenService {
	List<QuyenDTO> getAll();
	QuyenDTO save(QuyenDTO quyenDTO);
	Quyen getById(Integer id);
	ApiResponse delete(Integer id);
}
