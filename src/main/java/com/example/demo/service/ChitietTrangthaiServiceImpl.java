package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietTrangThaiConvert;
import com.example.demo.dto.ChitietTrangThaiDTO;
import com.example.demo.entity.CtTrangthai;
import com.example.demo.repository.ChitietTrangThaiRepository;

@Service
public class ChitietTrangthaiServiceImpl implements ChitietTrangthaiService{
		@Autowired
		private ChitietTrangThaiRepository chitietTrangThaiRepository;
		@Autowired
		private ModelMapper modelMapper;
		@Autowired
		private ChitietTrangThaiConvert chitietTrangThaiConvert;
		@Override
		public ChitietTrangThaiDTO getTrangThaibyHD(Integer mahd) {
			// TODO Auto-generated method stub
			CtTrangthai ctTrangthai=chitietTrangThaiRepository.getCT_TrangThai(mahd);
			return chitietTrangThaiConvert.toDTO(ctTrangthai);
		}
		@Override
		public List<ChitietTrangThaiDTO> getAllTrangThai() {
			// TODO Auto-generated method stub
			List<CtTrangthai> ctTrangthais=chitietTrangThaiRepository.findAll();
			
			List<ChitietTrangThaiDTO> chitietTrangThaiDTOs=new ArrayList<ChitietTrangThaiDTO>();
			for(CtTrangthai cttrangthai:ctTrangthais) {
				chitietTrangThaiDTOs.add(chitietTrangThaiConvert.toDTO(cttrangthai));
			}
			return chitietTrangThaiDTOs;
		}
		
}
