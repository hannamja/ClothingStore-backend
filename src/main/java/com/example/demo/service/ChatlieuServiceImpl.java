package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ChatlieuDTO;
import com.example.demo.entity.Chatlieu;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Mathang;
import com.example.demo.repository.ChatlieuRepository;
import com.example.demo.repository.MathangRepository;

@Service
public class ChatlieuServiceImpl implements ChatlieuService {
	@Autowired
	private ChatlieuRepository chatlieuRepository;
	@Autowired
	private MathangRepository mathangRepository;
	@Autowired 
	private ModelMapper modelMapper;
	@Override
	public List<ChatlieuDTO> getAllChatlieu() {
		// TODO Auto-generated method stub
		return chatlieuRepository.findAll().stream().map(chatlieu->modelMapper.map(chatlieu, ChatlieuDTO.class)).collect(Collectors.toList());
	}
	@Override
	public Chatlieu findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Chatlieu> chatlieuOptional=chatlieuRepository.findById(id);
		return chatlieuOptional.orElse(null);
	}
	@Override
	public ChatlieuDTO save(Chatlieu chatlieu) {
		// TODO Auto-generated method stub
		return modelMapper.map(chatlieuRepository.save(chatlieu), ChatlieuDTO.class);
	}
	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Chatlieu> km = chatlieuRepository.findById(id);
		if(!km.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<Mathang> list = mathangRepository.getMathangByCl(id);
		if(list.size() == 0) {
			chatlieuRepository.delete(km.get());
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Chất hiệu đã tồn tại trên mặt hàng!", null);
		}
	}
	
}
