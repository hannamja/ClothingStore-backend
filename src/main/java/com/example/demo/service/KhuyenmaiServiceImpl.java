package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.Khuyenmaiconvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtKhuyenmaiDTO;
import com.example.demo.dto.KhuyenmaiDTO;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtKhuyenmaiId;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Mathang;
import com.example.demo.repository.CtKhuyenmaiRepository;
import com.example.demo.repository.KhuyenmaiRepository;
import com.example.demo.repository.MathangRepository;

@Service
public class KhuyenmaiServiceImpl implements KhuyenmaiService {
	@Autowired
	private KhuyenmaiRepository khuyenmaiRepository;
	@Autowired
	private CtKhuyenmaiRepository ctKhuyenmaiRepository;
	@Autowired
	private Khuyenmaiconvert khuyenmaiconvert;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired MathangRepository mathangRepository;
	@Override
	public List<KhuyenmaiDTO> getAll() {
		// TODO Auto-generated method stub
		List<KhuyenmaiDTO> list = new ArrayList<KhuyenmaiDTO>();
		for(Khuyenmai km : khuyenmaiRepository.findAll()) {
			list.add(khuyenmaiconvert.toDTO(km, ctKhuyenmaiRepository.getKhuyenmai1(km.getMakm())));
		}
		return list;
	}

	@Override
	public KhuyenmaiDTO save(KhuyenmaiDTO km) {
		// TODO Auto-generated method stub
		Khuyenmai kmSaved = khuyenmaiRepository.save(khuyenmaiconvert.toEntity(km));
		List<CtKhuyenmai> ctkms = new ArrayList<CtKhuyenmai>();
		for(CtKhuyenmaiDTO kmDTo : km.getCtKhuyenmais()) {
			ctkms.add(new CtKhuyenmai(new CtKhuyenmaiId(kmSaved.getMakm(), kmDTo.getId().getMamh()), kmSaved, new Mathang(kmDTo.getId().getMamh()), kmDTo.getMucgiam()));
		}
		if(ctKhuyenmaiRepository.getKhuyenmai1(km.getMakm())!=null) {
			ctKhuyenmaiRepository.deleteAll(ctKhuyenmaiRepository.getKhuyenmai1(km.getMakm()));
		};
		ctKhuyenmaiRepository.saveAll(ctkms);
		return khuyenmaiconvert.toDTO(kmSaved, ctkms);
	}

	@Override
	public ApiResponse detele(Integer id) {
		// TODO Auto-generated method stub
		Optional<Khuyenmai> km = khuyenmaiRepository.findById(id);
		if(!km.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<CtKhuyenmai> list = ctKhuyenmaiRepository.getKhuyenmai1(id);
		if(list.size() == 0) {
			khuyenmaiRepository.delete(km.get());
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Khuyến mãi đã tồn tại chi tiết khuyến mãi!", null);
		}
		
	}

}
