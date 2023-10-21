package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietHoadonConvert;
import com.example.demo.convert.ChitietMathangConvert;
import com.example.demo.convert.CtPhieuNhapConvert;
import com.example.demo.convert.HoadonConvert;
import com.example.demo.convert.ImportConvert;
import com.example.demo.dto.CtPhieunhapDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.entity.CtPhieunhap;
import com.example.demo.entity.CtPhieunhapId;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Phieunhap;
import com.example.demo.repository.ChitietHoadonRepository;
import com.example.demo.repository.ChitietMathangRepository;
import com.example.demo.repository.ChitietTrangThaiRepository;
import com.example.demo.repository.CtPhieunhapRepository;
import com.example.demo.repository.HoadonRepository;
import com.example.demo.repository.PhieunhapRepository;

@Service
public class PhieunhapServicesImpl implements PhieunhapService {
	@Autowired
	private PhieunhapRepository phieunhapRepository;
	@Autowired
	private ImportConvert importConvert;
	@Autowired
	private CtPhieuNhapConvert ctPhieuNhapConvert;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	ChitietMathangConvert chitietMathangConvert;
	@Autowired
	private CtPhieunhapRepository ctPhieunhapRepository;
	
	@Override
	public List<ImportDTO> getAllPhieunhap() {
		// TODO Auto-generated method stub
		List<Phieunhap> phieunhaps=phieunhapRepository.findAll();
		List<ImportDTO> importDTOs=new ArrayList<ImportDTO>();
		for(Phieunhap pn : phieunhaps) {
			importDTOs.add(importConvert.toDTO(pn,ctPhieunhapRepository.getCT_Pn(pn.getMapn())));
		}
		return importDTOs;
	}

	@Override
	public ImportDTO save(ImportDTO phieunhapDTO) {
		// TODO Auto-generated method stub
		Phieunhap phieunhap = importConvert.toEntity(phieunhapDTO);
		Phieunhap phieunhapSaved = phieunhapRepository.save(phieunhap);
		
		List<CtPhieunhap> ctpns = new ArrayList<CtPhieunhap>();
		for(CtPhieunhapDTO ctpn : phieunhapDTO.getCtPhieunhapDTOs()) {
			ctpns.add(new CtPhieunhap(new CtPhieunhapId(phieunhapSaved.getMapn(),ctpn.getCtMathangDTO().getId()), chitietMathangConvert.toEntity(ctpn.getCtMathangDTO()), ctpn.getSoluong(), ctpn.getDongia()));
		}
		if(ctPhieunhapRepository.getCT_Pn(phieunhapDTO.getMapn())!=null) {
			ctPhieunhapRepository.deleteAll(ctPhieunhapRepository.getCT_Pn(phieunhapDTO.getMapn()));
		}
		for(CtPhieunhap ct : ctpns) {
			System.out.println("phieu nhap" + ct.getId().getMapn());
		}
		ctPhieunhapRepository.saveAll(ctpns);
		return modelMapper.map(phieunhapSaved, ImportDTO.class);
	}
	
	@Override
	public ImportDTO findById(Integer mapn) {
		// TODO Auto-generated method stub
		Optional<Phieunhap> phieunhap = phieunhapRepository.findById(mapn);
		
		return importConvert.toDTO(phieunhap.get(), ctPhieunhapRepository.getCT_Pn(mapn));
	}
}
