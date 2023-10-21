package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.HinhanhConvert;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.repository.HinhanhRepository;

@Service
public class HinhanhServiceImpl implements HinhanhService {
	@Autowired
	private HinhanhRepository hinhanhRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired 
	private HinhanhConvert hinhanhConvert; 
	@Override
	public List<HinhanhDTO> saveAllHinhanh(List<Hinhanhmh> hinhanhmhs) {
		// TODO Auto-generated method stub
		return hinhanhRepository.saveAll(hinhanhmhs).stream().map(hinhanhs->modelMapper.map(hinhanhs, HinhanhDTO.class)).collect(Collectors.toList());
	}
	@Override
	public List<HinhanhDTO> getAllHinhanh() {
		// TODO Auto-generated method stub
		return hinhanhRepository.findAll().stream().map(hinhanh->modelMapper.map(hinhanh, HinhanhDTO.class)).collect(Collectors.toList());
	}
	@Override
	public List<HinhanhDTO> getHinhanhByMH(Integer id) {
		// TODO Auto-generated method stub
		List<Hinhanhmh> hinhanhmhs=hinhanhRepository.getHAByMH(id);
		List<HinhanhDTO> hinhanhDTOs=new ArrayList<HinhanhDTO>();
		for (Hinhanhmh hinhanh : hinhanhmhs) {
			hinhanhDTOs.add(hinhanhConvert.toDTO(hinhanh));
		}
		return hinhanhDTOs;
	}
	@Override
	public HinhanhDTO save(HinhanhDTO hinhanhDTO) {
		// TODO Auto-generated method stub
		Hinhanhmh hinhanhmh=hinhanhConvert.toEntity(hinhanhDTO);
		return modelMapper.map(hinhanhRepository.save(hinhanhmh), HinhanhDTO.class);
	}
	@Override
	public List<HinhanhDTO> saveAll(List<HinhanhDTO> hinhanhDTOs) {
		// TODO Auto-generated method stub
		List<Hinhanhmh> hinhanhmhs=new ArrayList<Hinhanhmh>();
		for(HinhanhDTO hinhanhDTO:hinhanhDTOs) {
			hinhanhmhs.add(hinhanhConvert.toEntity(hinhanhDTO));
		}
		return hinhanhRepository.saveAll(hinhanhmhs).stream().map(hinhanh->modelMapper.map(hinhanh, HinhanhDTO.class)).collect(Collectors.toList());
	}
	
	
	
}
