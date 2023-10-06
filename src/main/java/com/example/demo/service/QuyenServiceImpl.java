package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.QuyenConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.QuyenDTO;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtQuyen;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Quyen;
import com.example.demo.repository.CtQuyenRepository;
import com.example.demo.repository.QuyenRepository;

@Service
public class QuyenServiceImpl implements QuyenService {
	@Autowired
	QuyenRepository quyenRepository;
	@Autowired
	CtQuyenRepository ctQuyenRepository;
	@Autowired
	QuyenConvert convert;
	@Override
	public List<QuyenDTO> getAll() {
		List<Quyen> list = quyenRepository.findAll();
		List<QuyenDTO> lDTO = new ArrayList<QuyenDTO>();
		for(Quyen q : list) {
			lDTO.add(convert.toDTO(q));
		}
		return lDTO;
		
	}

	@Override
	public QuyenDTO save(QuyenDTO quyenDTO) {
		// TODO Auto-generated method stub
		Quyen q = quyenRepository.save(convert.toEntity(quyenDTO));
		return convert.toDTO(q);
	}

	@Override
	public Quyen getById(Integer id) {
		// TODO Auto-generated method stub
		Quyen q = quyenRepository.findById(id).get();
		return q;
	}

	@Override
	public ApiResponse delete(Integer id) {
		Optional<Quyen> temp = quyenRepository.findById(id);
		if(!temp.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<CtQuyen> list = ctQuyenRepository.getCt_q(id);
		if(list.size()==0) {
			quyenRepository.deleteById(id);
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			return new ApiResponse(404, "Quyền hiện đang được cấp!", null);
		}
	}

}
