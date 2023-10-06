package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.entity.CtHoadon;

public interface ChitietHoadonService {
	List<ChitietHoadonDTO> getCtHoadonByHD(Integer mahd);
	List<ChitietHoadonDTO> getAllCtHoadon();
	List<ChitietHoadonDTO> saveCtHoadonAll(List<ChitietHoadonDTO> ctHoadons);
	ChitietHoadonDTO saveCthoadon(ChitietHoadonDTO ctHoadon);
}
