package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.Phieudat;

public interface PhieudatService {
	List<PhieudatDTO> getAllPhieudat();
	PhieudatDTO save(PhieudatDTO phieudatDTO);
	PhieudatDTO findById(Integer mapd);
	ApiResponse delete(Integer id);
}
