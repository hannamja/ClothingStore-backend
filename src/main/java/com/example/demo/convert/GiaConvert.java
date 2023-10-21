package com.example.demo.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.GiaDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.entity.Gia;
import com.example.demo.entity.GiaId;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanvien;

@Component
public class GiaConvert {
	@Autowired
	private ModelMapper modelMapper;
	public GiaDTO toDTO(Gia gia) {
		GiaDTO giaDTO=new GiaDTO();
		MathangDTO mathangDTO=new MathangDTO();
		mathangDTO.setMamh(gia.getMathang().getMamh());
		mathangDTO.setTenmh(gia.getMathang().getTenmh());
		giaDTO.setMathangDTO(mathangDTO);
		giaDTO.setNgayapdung(gia.getId().getNgayapdung());
		NhanvienDTO nhanvienDTO=new NhanvienDTO();
		nhanvienDTO.setManv(gia.getId().getManv());
		nhanvienDTO.setTennv(gia.getNhanvien().getTennv());
		giaDTO.setNhanvienDTO(nhanvienDTO);
		giaDTO.setGia(gia.getGia());
		giaDTO.setNgaykt(gia.getNgaykt());
		return giaDTO;
	}
	public Gia toEntity(GiaDTO giaDTO) {
		Gia gia=new Gia();
		Mathang mathang=new Mathang();
		mathang.setMamh(giaDTO.getMathangDTO().getMamh());
		mathang.setTenmh(giaDTO.getMathangDTO().getTenmh());
		gia.setMathang(mathang);
		GiaId giaId=new GiaId();
		giaId.setMamh(giaDTO.getMathangDTO().getMamh());
		giaId.setManv(giaDTO.getNhanvienDTO().getManv());
		giaId.setNgayapdung(giaDTO.getNgayapdung());
		gia.setId(giaId);
		gia.setGia(giaDTO.getGia());
		gia.setNgaykt(giaDTO.getNgaykt());
		Nhanvien nhanvien=new Nhanvien();
		nhanvien.setManv(giaDTO.getNhanvienDTO().getManv());
		nhanvien.setTennv(giaDTO.getNhanvienDTO().getTennv());
		gia.setNhanvien(nhanvien);
		return gia;
		
	}
}
