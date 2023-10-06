package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.DanhgiaConvert;
import com.example.demo.dto.DanhgiaDTO;
import com.example.demo.entity.Danhgia;
import com.example.demo.repository.DanhgiaRepository;

@Service
public class DanhgiaServiceImpl implements DanhgiaService {
	@Autowired
	DanhgiaRepository danhgiaRepository;
	@Autowired
	DanhgiaConvert danhgiaConvert;
	@Override
	public List<DanhgiaDTO> getAllDanhgia() {
		List<Danhgia> danhgias = danhgiaRepository.findAll();
		List<DanhgiaDTO> danhgiaDTOs = new ArrayList<DanhgiaDTO>();
		for(Danhgia dg : danhgias) {
			danhgiaDTOs.add(danhgiaConvert.toDTO(dg));
		}
		return danhgiaDTOs;
	}

	@Override
	public DanhgiaDTO save(DanhgiaDTO danhgiaDTO) {
		// TODO Auto-generated method stub
		Danhgia danhgia = danhgiaConvert.toEntity(danhgiaDTO);
		Danhgia danhgiaSaved = danhgiaRepository.save(danhgia);
		return danhgiaConvert.toDTO(danhgiaSaved);
	}

}
