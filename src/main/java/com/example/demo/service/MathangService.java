package com.example.demo.service;


import java.util.Date;
import java.util.List;

import com.example.demo.dto.ApiRes;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.Mathang;

public interface MathangService {
	List<MathangDTO> getAllMathang();
	List<MathangDTO> getAllMathangAd();
	MathangDTO findById(Integer id);
	ApiRes save(MathangDTO mathangDTO,Integer id,Date date);
	List<MathangDTO> getAllMathangByLoai(Integer id);
	List<MathangDTO> getAllMathangByNh(Integer id);
	List<MathangDTO> getAllMathangByName(String name);
	ApiResponse delete(Integer id);
}
