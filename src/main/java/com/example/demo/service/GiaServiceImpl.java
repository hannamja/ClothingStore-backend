package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.GiaConvert;
import com.example.demo.dto.GiaDTO;
import com.example.demo.entity.Gia;
import com.example.demo.repository.GiaRepository;

@Service
public class GiaServiceImpl implements GiaService {
	@Autowired
	private GiaRepository giaRepository;
	@Autowired
	private GiaConvert giaConvert;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<GiaDTO> getAllGia() {
		// TODO Auto-generated method stub
		List<Gia> gias=giaRepository.findAll();
		List<GiaDTO> giaDTOs=new ArrayList<GiaDTO>();
		for(Gia gia:gias) {
			giaDTOs.add(giaConvert.toDTO(gia));
		}
		return giaDTOs;
	}


	@Override
	public GiaDTO save(GiaDTO giaDTO) {
		// TODO Auto-generated method stub
		Gia gia=giaConvert.toEntity(giaDTO);
		return modelMapper.map(giaRepository.save(gia), GiaDTO.class);
	}
	
	
	
}
