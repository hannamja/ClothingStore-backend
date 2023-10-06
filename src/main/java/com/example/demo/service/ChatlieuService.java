package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ChatlieuDTO;
import com.example.demo.dto.NhacungcapDTO;
import com.example.demo.entity.Chatlieu;
import com.example.demo.entity.Nhacungcap;

public interface ChatlieuService {
	 List<ChatlieuDTO> getAllChatlieu();
	  Chatlieu findById(Integer id);
	  ChatlieuDTO save(Chatlieu chatlieu);
	  ApiResponse delete(Integer id);
}
