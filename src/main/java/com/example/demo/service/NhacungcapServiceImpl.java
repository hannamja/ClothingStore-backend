package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.NhacungcapDTO;
import com.example.demo.entity.Nhacungcap;
import com.example.demo.entity.Phieudat;
import com.example.demo.repository.NhacungcapRepository;
import com.example.demo.repository.PhieudatRepository;

@Service
public class NhacungcapServiceImpl implements NhacungcapService {
	@Autowired
	private NhacungcapRepository nhaccRepository;
	@Autowired
	private PhieudatRepository phieudatRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<NhacungcapDTO> getAllNhaCC() {
		// TODO Auto-generated method stub
		return nhaccRepository.findAll().stream().map(nhacungcap->modelMapper.map(nhacungcap, NhacungcapDTO.class)).collect(Collectors.toList());
	}
	@Override
	public Nhacungcap findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Nhacungcap> nhacaungcap=nhaccRepository.findById(id);
		return nhacaungcap.orElse(null);
	}
	@Override
	public NhacungcapDTO save(Nhacungcap nhacungcap) {
		// TODO Auto-generated method stub
		return modelMapper.map(nhaccRepository.save(nhacungcap), NhacungcapDTO.class);
		
	}
	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Nhacungcap> n = nhaccRepository.findById(id);
		if(!n.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<Phieudat> list = phieudatRepository.getPdByNcc(id);
		if(list.size()==0) {
			nhaccRepository.deleteById(id);
			return new ApiResponse(200, "Thành công", null);
		}
		return new ApiResponse(404, "Nhà cung cấp đã có phiếu đặt!", null);
		
	}
	@Override
	public List<NhacungcapDTO> saveNhancungcaps(List<Nhacungcap> nhacungcaps) {
		// TODO Auto-generated method stub
		
		return nhaccRepository.saveAll(nhacungcaps).stream().map(nhacungcaps1->modelMapper.map(nhacungcaps1, NhacungcapDTO.class)).collect(Collectors.toList());
	}

}
