package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.KhuyenmaiDTO;
import com.example.demo.entity.Khuyenmai;

public interface KhuyenmaiService {
	List<KhuyenmaiDTO> getAll();
	KhuyenmaiDTO save(KhuyenmaiDTO km);
	ApiResponse detele(Integer id);
}
