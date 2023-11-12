package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietMathangConvert;
import com.example.demo.convert.PhieudatConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtPhieudatDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.CtPhieudatId;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Phieudat;
import com.example.demo.entity.Phieunhap;
import com.example.demo.repository.CtPhieudatRepository;
import com.example.demo.repository.CtPhieunhapRepository;
import com.example.demo.repository.PhieudatRepository;
import com.example.demo.repository.PhieunhapRepository;

@Service
public class PhieudatServiceImpl implements PhieudatService {
	@Autowired
	PhieudatRepository phieudatRepository;
	@Autowired
	CtPhieudatRepository ctPhieudatRepository;
	@Autowired
	PhieunhapRepository phieunhapRepository;
	@Autowired
	PhieudatConvert phieudatConvert;
	@Autowired
	ChitietMathangConvert chitietMathangConvert;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<PhieudatDTO> getAllPhieudat() {
		// TODO Auto-generated method stub
		List<Phieudat> phieudats = phieudatRepository.findAll();
		List<PhieudatDTO> phieudatDTOs=new ArrayList<PhieudatDTO>();
		for(Phieudat pd : phieudats) {
			phieudatDTOs.add(phieudatConvert.toDTO(pd, phieunhapRepository.getPns(pd.getMapd()), ctPhieudatRepository.getCT_Pd(pd.getMapd())));
		}
		return phieudatDTOs;
	}
	@Override
	public PhieudatDTO save(PhieudatDTO phieudatDTO) {
		
		Phieudat phieudat = phieudatConvert.toEntiy(phieudatDTO);
		Phieudat phieudatSaved = phieudatRepository.save(phieudat);
		
		List<CtPhieudat> ctpds = new ArrayList<CtPhieudat>();
		for(CtPhieudatDTO ctpd : phieudatDTO.getCtPhieudatDTOs()) {
			ctpds.add(new CtPhieudat(new CtPhieudatId(ctpd.getCtMathangDTOs().getId(),phieudatSaved.getMapd()),chitietMathangConvert.toEntity(ctpd.getCtMathangDTOs()), ctpd.getSoluong(), ctpd.getDongia()));
		}
		if(ctPhieudatRepository.getCT_Pd(phieudatDTO.getMapd())!=null) {
			ctPhieudatRepository.deleteAll(ctPhieudatRepository.getCT_Pd(phieudatDTO.getMapd()));
		}
		ctPhieudatRepository.saveAll(ctpds);
		return modelMapper.map(phieudatSaved, PhieudatDTO.class);
	}
	
	
	@Override
	public PhieudatDTO findById(Integer mapd) {
		// TODO Auto-generated method stub
		Optional<Phieudat> pd = phieudatRepository.findById(mapd);
		if(pd.isPresent())
			return phieudatConvert.toDTO(pd.get(), phieunhapRepository.getPns(mapd), ctPhieudatRepository.getCT_Pd(mapd));
		return new PhieudatDTO();
	}
	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Phieudat> pd = phieudatRepository.findById(id);
		if(!pd.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<Phieunhap> list = phieunhapRepository.getPns(id);
		if(list.size() == 0) {
			ctPhieudatRepository.deleteAll(ctPhieudatRepository.getCT_Pd(id));
			phieudatRepository.delete(pd.get());
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Phiếu dặt đã tồn tại phiếu nhập!", null);
		}
	}
}
