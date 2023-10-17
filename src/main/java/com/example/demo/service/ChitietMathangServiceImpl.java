package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietMathangConvert;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.entity.CtMathang;
import com.example.demo.repository.ChitietMathangRepository;

@Service
public class ChitietMathangServiceImpl implements ChitietMathangService {
	@Autowired
	private ChitietMathangRepository chitietMathangRepository;
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private ChitietMathangConvert chitietMathangConvert;
	@Override
	public List<ChitietMathangDTO> getAllCtMathang() {
		// TODO Auto-generated method stub
		List<CtMathang> ctMathangs=chitietMathangRepository.findAll();
		List<ChitietMathangDTO> chitietMathangDTOs=new ArrayList<ChitietMathangDTO>();
		for(CtMathang ctmathang:ctMathangs) {
			chitietMathangDTOs.add(chitietMathangConvert.toDTO(ctmathang));
		}
		return chitietMathangDTOs;
	}
	@Override
	public ChitietMathangDTO saveCtMathang(ChitietMathangDTO chitietMathangDTO) {
		// TODO Auto-generated method stub
		CtMathang ctMathang=chitietMathangConvert.toEntity(chitietMathangDTO);
		return modelMapper.map(chitietMathangRepository.save(ctMathang),ChitietMathangDTO.class );
	}
	@Override
	public List<ChitietMathangDTO> getCtMathang(Integer mamh) {
		// TODO Auto-generated method stub
		List<CtMathang> ctMathangs=chitietMathangRepository.getCTMathang(mamh);
		List<ChitietMathangDTO> chitietMathangDTOs=new ArrayList<ChitietMathangDTO>();
		for(CtMathang ctmathang:ctMathangs) {
			chitietMathangDTOs.add(chitietMathangConvert.toDTO(ctmathang));
		}
		return chitietMathangDTOs;
	}
	
	
}
