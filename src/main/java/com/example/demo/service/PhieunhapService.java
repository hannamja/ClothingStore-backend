package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ImportDTO;

public interface PhieunhapService {
List<ImportDTO> getAllPhieunhap();
ImportDTO save (ImportDTO phieunhapDTO);
ImportDTO findById (Integer phieunhapDTO);
}
