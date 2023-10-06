package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HinhanhDTO;
import com.example.demo.entity.Hinhanhmh;

public interface HinhanhService {
	List<HinhanhDTO> saveAllHinhanh(List<Hinhanhmh> hinhanhmhs);
	List<HinhanhDTO> getAllHinhanh();
	List<HinhanhDTO> getHinhanhByMH(Integer id);
	HinhanhDTO save(HinhanhDTO hinhanhDTO);
	List<HinhanhDTO> saveAll(List<HinhanhDTO> hinhanhDTOs);
}
