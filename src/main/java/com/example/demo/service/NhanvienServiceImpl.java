package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.repository.NhanvienRepository;

@Service
public class NhanvienServiceImpl implements NhanvienService{
	@Autowired
	private NhanvienRepository nhanvienRepository;
	@Autowired
	private	ModelMapper modelMapper;
	@Override
	public List<NhanvienDTO> getAllNhanvien() {
		// TODO Auto-generated method stub
		return nhanvienRepository.findAll().stream().map(nhanvien->modelMapper.map(nhanvien, NhanvienDTO.class)).collect(Collectors.toList());
	}
	@Override
	public Nhanvien getNhanvienById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Nhanvien> nhavien=nhanvienRepository.findById(id);
		return nhavien.orElse(null);
	}
	@Override
	public NhanvienDTO save(Nhanvien nhanvien) {
		// TODO Auto-generated method stub
		return modelMapper.map(nhanvienRepository.save(nhanvien),NhanvienDTO.class );
	}
	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			Nhanvien nv = nhanvienRepository.findById(id).get();
			nv.setTrangthai("1");
			nhanvienRepository.save(nv);
			return new ApiResponse(200, "Thành công!",null);
		}
		catch(Exception e) {
			return new ApiResponse(404, "Ko thành công!",null);
		}
	}
	@Override
	public List<NhanvienDTO> getNhanvienByname(String name) {
		// TODO Auto-generated method stub
		List<Nhanvien> nhanviens=nhanvienRepository.findAll();
		List<Nhanvien> nhanviens2=new ArrayList<Nhanvien>();
		for(Nhanvien nv :nhanviens) {
			if (nv.getTennv().equals(name)) {
				nhanviens2.add(nv);
			}
		}
		return nhanviens2.stream().map(nv->modelMapper.map(nv, NhanvienDTO.class)).collect(Collectors.toList());
	}
	
	
}
