package com.example.demo.convert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CtKhuyenmaiDTO;
import com.example.demo.dto.KhuyenmaiDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtKhuyenmaiId;
import com.example.demo.entity.Khuyenmai;
import com.example.demo.entity.Nhanvien;

@Component
public class Khuyenmaiconvert {
	public KhuyenmaiDTO toDTO(Khuyenmai km, List<CtKhuyenmai> list) {
		KhuyenmaiDTO kmDTO = new KhuyenmaiDTO();
		kmDTO.setMakm(km.getMakm());
		kmDTO.setLydo(km.getLydo());
		kmDTO.setNgaybd(km.getNgaybd());
		kmDTO.setNgaykt(km.getNgaykt());
		kmDTO.setNhanvien(new NhanvienDTO(km.getNhanvien().getManv(), km.getNhanvien().getTennv()));
		
		List<CtKhuyenmaiDTO> ctkms = new ArrayList<CtKhuyenmaiDTO>();
		for(CtKhuyenmai ct : list) {
			CtKhuyenmaiDTO temp = new CtKhuyenmaiDTO();
			temp.setId(new CtKhuyenmaiId(ct.getId().getMakm(), ct.getId().getMamh()));
			temp.setMucgiam(ct.getMucgiam());
			ctkms.add(temp);
		}
		kmDTO.setCtKhuyenmais(ctkms);
		return kmDTO;
	}
	
	public Khuyenmai toEntity(KhuyenmaiDTO kmDTO) {
		Khuyenmai km = new Khuyenmai();
		km.setMakm(kmDTO.getMakm());
		km.setLydo(kmDTO.getLydo());
		km.setNgaybd(kmDTO.getNgaybd());
		km.setNgaykt(kmDTO.getNgaykt());
		km.setNhanvien(new Nhanvien(kmDTO.getNhanvien().getManv()));
		return km;
	}
	
}
