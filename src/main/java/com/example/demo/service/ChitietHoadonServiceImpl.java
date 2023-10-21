package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietHoadonConvert;
import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.entity.CtHoadon;
import com.example.demo.repository.ChitietHoadonRepository;

@Service
public class ChitietHoadonServiceImpl implements ChitietHoadonService {
	@Autowired
	private ChitietHoadonRepository chitietHoadonRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ChitietHoadonConvert chitietHoadonConvert;
	@Override
	public List<ChitietHoadonDTO> getCtHoadonByHD(Integer mahd) {
		// TODO Auto-generated method stub
		List<CtHoadon> ctHoadons=chitietHoadonRepository.getCT_Hoadon(mahd);
		List<ChitietHoadonDTO> chitietHoadonDTOs=new ArrayList<ChitietHoadonDTO>();
		for(CtHoadon cthoadon: ctHoadons) {
			chitietHoadonDTOs.add(chitietHoadonConvert.toDTO(cthoadon));
		}
		return chitietHoadonDTOs;
	}
	@Override
	public List<ChitietHoadonDTO> getAllCtHoadon() {
		// TODO Auto-generated method stub
		List<CtHoadon> ctHoadons=chitietHoadonRepository.findAll();
		List<ChitietHoadonDTO> chitietHoadonDTOs=new ArrayList<ChitietHoadonDTO>();
		for(CtHoadon cthoadon: ctHoadons) {
			chitietHoadonDTOs.add(chitietHoadonConvert.toDTO(cthoadon));
		}
		return chitietHoadonDTOs;
	}
	@Override
	public List<ChitietHoadonDTO> saveCtHoadonAll(List<ChitietHoadonDTO> ctHoadons) {
		// TODO Auto-generated method stub
		List<CtHoadon> ctHoadons2=new ArrayList<CtHoadon>();
		for(ChitietHoadonDTO cthoadon: ctHoadons) {
			ctHoadons2.add(chitietHoadonConvert.toEntity(cthoadon));
		}
		List<CtHoadon> ctHoadons3=chitietHoadonRepository.saveAll(ctHoadons2);
		List<ChitietHoadonDTO> chitietHoadonDTOs=new ArrayList<ChitietHoadonDTO>();
		for(CtHoadon cthoadon: ctHoadons3) {
			chitietHoadonDTOs.add(chitietHoadonConvert.toDTO(cthoadon));
		}
		return chitietHoadonDTOs;
	}
	@Override
	public ChitietHoadonDTO saveCthoadon(ChitietHoadonDTO chitietHoadonDTO) {
		// TODO Auto-generated method stub
		CtHoadon ctHoadon=chitietHoadonConvert.toEntity(chitietHoadonDTO);
		CtHoadon ctHoadon2=chitietHoadonRepository.save(ctHoadon);
		return chitietHoadonConvert.toDTO(ctHoadon2);
	}
	
}
