package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.NhanhieuDTO;
import com.example.demo.entity.Loaimh;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanhieu;
import com.example.demo.repository.MathangRepository;
import com.example.demo.repository.NhanhieuRepository;

@Service
public class NhanhieuServiceImpl implements NhanhieuService {
	@Autowired
	private NhanhieuRepository nhanhieuRepository;
	@Autowired
	private MathangRepository mathangRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<NhanhieuDTO> getAllNhanhieuMh() {
		// TODO Auto-generated method stub
		return nhanhieuRepository.findAll().stream().map(nhanhieu->modelMapper.map(nhanhieu, NhanhieuDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Nhanhieu getLoaimhById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Nhanhieu> nhanhieuOptional=nhanhieuRepository.findById(id);
		return nhanhieuOptional.orElse(null);
	}

	@Override
	public NhanhieuDTO save(Nhanhieu nhanhieu) {
		// TODO Auto-generated method stub
		return modelMapper.map(nhanhieuRepository.save(nhanhieu), NhanhieuDTO.class);
	}

	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Nhanhieu> km = nhanhieuRepository.findById(id);
		if(!km.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<Mathang> list = mathangRepository.getMathangByNh(id);
		if(list.size() == 0) {
			nhanhieuRepository.delete(km.get());
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Nhãn hiệu đã tồn tại mặt hàng!", null);
		}
	}

}
