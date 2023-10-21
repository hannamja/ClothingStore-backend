package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.CtQConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtQuyenDTO;
import com.example.demo.dto.CtQuyenID;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.CtQuyen;
import com.example.demo.entity.Taikhoan;
import com.example.demo.repository.CtQuyenRepository;

@Service
public class CtQuyenServiceImpl implements CtQuyenService {
	@Autowired
	private CtQuyenRepository ctQuyenRepository;
	@Autowired
	private CtQConvert convert;
	@Override
	public List<CtQuyenDTO> getCtQuyen(Integer id) {
		// TODO Auto-generated method stub
		List<CtQuyen> ctq = ctQuyenRepository.getCt_q1(id);
		List<CtQuyenDTO> ctqDTO = new ArrayList<CtQuyenDTO>();
		for(CtQuyen ct:ctq) {
			ctqDTO.add(convert.toDTO(ct));
		}
		return ctqDTO;
	}

	@Override
	public ApiResponse save(List<CtQuyenDTO> ctqDTO, Integer tk) {
		// TODO Auto-generated method stub
		List<CtQuyen> list = new ArrayList<CtQuyen>();
		List<CtQuyen> temp = ctQuyenRepository.getCt_q1(tk);
		if(temp.size()!=0) {
			ctQuyenRepository.deleteAll(temp);
		}
		for(CtQuyenDTO ct : ctqDTO) {
			ct.setTaikhoan(new TaikhoanDTO(tk));
			ct.setId(new CtQuyenID(ct.getId().getNgaystart(), ct.getId().getMaquyen(), tk));
			list.add(convert.toEntity(ct));
		}
		ctQuyenRepository.saveAll(list);
		return new ApiResponse(200, "Thành công",null);
	}

}
