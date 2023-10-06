package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.HoadonDTO;
import com.example.demo.entity.Hoadon;

public interface HoadonService {
	HoadonDTO save(HoadonDTO hoadonDTO);
	HoadonDTO cancel(HoadonDTO hoadonDTO);
	HoadonDTO confirm(HoadonDTO hoadonDTO);
	HoadonDTO complete(HoadonDTO hoadonDTO);
	HoadonDTO processing(HoadonDTO hoadonDTO);
	HoadonDTO updateTT(HoadonDTO hoadonDTO);
	HoadonDTO findById (Integer id);
	List<HoadonDTO> getAllHoadon();
}
