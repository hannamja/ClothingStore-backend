package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.NhacungcapDTO;
import com.example.demo.entity.Nhacungcap;

public interface NhacungcapService {
  List<NhacungcapDTO> getAllNhaCC();
  Nhacungcap findById(Integer id);
  NhacungcapDTO save(Nhacungcap nhacungcap);
  ApiResponse delete(Integer id);
  List<NhacungcapDTO> saveNhancungcaps(List<Nhacungcap> nhacungcaps);
}
