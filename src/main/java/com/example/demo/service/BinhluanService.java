package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BinhluanDTO;

public interface BinhluanService {
	List<BinhluanDTO> getAllBinhluan();
	BinhluanDTO saveBinhluan(BinhluanDTO binhluanDTO);
}
