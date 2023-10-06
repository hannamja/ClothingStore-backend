package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.KhachhangDTO;
import com.example.demo.entity.Khachhang;

public interface KhachhangService {
	List<KhachhangDTO> getAllKH();
	Khachhang findById(Integer id);
	KhachhangDTO save(Khachhang khachhang);
	void delete(Integer id);
	List<KhachhangDTO> getKHByName(String name);
}
