package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KhachhangDTO;
import com.example.demo.entity.Khachhang;
import com.example.demo.repository.KhachhangRepository;

@Service
public class KhachhangServiceImpl implements KhachhangService {
	@Autowired
	private KhachhangRepository khachhangRepository;
	 @Autowired
	    private ModelMapper modelMapper;
	@Override
	public List<KhachhangDTO> getAllKH() {
		// TODO Auto-generated method stub
		return khachhangRepository.findAll().stream().map(khachhang->modelMapper.map(khachhang, KhachhangDTO.class)).collect(Collectors.toList());
	}
	@Override
	public Khachhang findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Khachhang> khachhang=khachhangRepository.findById(id);
		return khachhang.orElse(null);
	}
	@Override
	public KhachhangDTO save(Khachhang khachhang) {
		// TODO Auto-generated method stub
		return  modelMapper.map(khachhangRepository.save(khachhang), KhachhangDTO.class);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		khachhangRepository.deleteById(id);
	}
	@Override
	public List<KhachhangDTO> getKHByName(String name) {
		// TODO Auto-generated method stub
		List<Khachhang> khachhang=khachhangRepository.findAll();
		List<Khachhang> khachhangDTOs=new ArrayList<Khachhang>();
		for(Khachhang kh :khachhang) {
			if (kh.getHotenkh().equals(name)) {
				khachhangDTOs.add(kh);
			}
		}
		return khachhangDTOs.stream().map(khachhang1->modelMapper.map(khachhang1, KhachhangDTO.class)).collect(Collectors.toList());
	}
	
}
