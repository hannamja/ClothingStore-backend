package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Loaimh;
import com.example.demo.entity.Mathang;
import com.example.demo.repository.LoaimhRepository;
import com.example.demo.repository.MathangRepository;

@Service
public class LoaimhServiceImpl implements LoaimhService {
	@Autowired
	private LoaimhRepository loaimhRepository;
	@Autowired
	private MathangRepository mathangRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<LoaimhDTO> getAllLoaiMH() {
		// TODO Auto-generated method stub
		return loaimhRepository.findAll().stream().map(loaimh->modelMapper.map(loaimh, LoaimhDTO.class)).collect(Collectors.toList());
	}
	@Override
	public Loaimh getLoaimhById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Loaimh> loaimh=loaimhRepository.findById(id);
		return loaimh.orElse(null);
	}
	@Override
	public LoaimhDTO save(Loaimh loaimh) {
		// TODO Auto-generated method stub
		return modelMapper.map(loaimhRepository.save(loaimh), LoaimhDTO.class);
	}
	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Loaimh> km = loaimhRepository.findById(id);
		if(!km.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<Mathang> list = mathangRepository.getMathangByLoai(id);
		if(list.size() == 0) {
			loaimhRepository.delete(km.get());
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Loại mặt hàng đã tồn tại mặt hàng!", null);
		}
	}
	
	
	

}
