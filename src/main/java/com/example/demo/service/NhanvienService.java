package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.entity.Nhanvien;

public interface NhanvienService {
	List<NhanvienDTO> getAllNhanvien();
	Nhanvien getNhanvienById(Integer id);
	NhanvienDTO save(Nhanvien nhanvien);
	ApiResponse delete(Integer id);
	List<NhanvienDTO> getNhanvienByname(String name);
}
