package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.dto.NhanhieuDTO;
import com.example.demo.entity.Loaimh;
import com.example.demo.entity.Nhanhieu;

public interface NhanhieuService {
	List<NhanhieuDTO> getAllNhanhieuMh();
	Nhanhieu getLoaimhById(Integer id);
	NhanhieuDTO save(Nhanhieu nhanhieu);
	ApiResponse delete(Integer id);
}
