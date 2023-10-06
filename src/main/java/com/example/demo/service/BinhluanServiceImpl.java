package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.BinhluanConvert;
import com.example.demo.dto.BinhluanDTO;
import com.example.demo.entity.Binhluan;
import com.example.demo.repository.BinhluanRepository;

@Service
public class BinhluanServiceImpl implements BinhluanService {
	@Autowired
	private BinhluanRepository binhluanRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BinhluanConvert binhluanConvert;
	@Override
	public List<BinhluanDTO> getAllBinhluan() {
		// TODO Auto-generated method stub
		List<Binhluan> binhluans=binhluanRepository.findAll();
		List<BinhluanDTO> binhluanDTOs=new ArrayList<BinhluanDTO>();
		for(Binhluan binhluan:binhluans) {
			binhluanDTOs.add(binhluanConvert.toDTO(binhluan));
		}
		return binhluanDTOs;
	}

	@Override
	public BinhluanDTO saveBinhluan(BinhluanDTO binhluanDTO) {
		// TODO Auto-generated method stub
		Binhluan binhluan=binhluanConvert.toEntity(binhluanDTO);
		Binhluan binhluan2=binhluanRepository.save(binhluan);
		return binhluanConvert.toDTO(binhluan2);
	}

}
