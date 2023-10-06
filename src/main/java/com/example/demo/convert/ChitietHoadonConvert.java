package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtHoadonId;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Mathang;

@Component
public class ChitietHoadonConvert {
	public ChitietHoadonDTO toDTO(CtHoadon ctHoadon) {
		ChitietHoadonDTO chitietHoadonDTO=new ChitietHoadonDTO();
		HoadonDTO hoadonDTO=new HoadonDTO();
		hoadonDTO.setMahd(ctHoadon.getHoadon().getMahd());
		chitietHoadonDTO.setHoadonDTO(hoadonDTO);
		ChitietMathangDTO chitietMathangDTO=new ChitietMathangDTO();
		chitietMathangDTO.setId(ctHoadon.getCtMathang().getId());
		chitietMathangDTO.setColor(ctHoadon.getCtMathang().getColor());
		chitietMathangDTO.setCurrentNumbeer(ctHoadon.getCtMathang().getCurrentNumbeer());
		chitietMathangDTO.setSize(ctHoadon.getCtMathang().getSize());
		MathangDTO mathangDTO=new MathangDTO();
		mathangDTO.setMamh(ctHoadon.getCtMathang().getMathang().getMamh());
		mathangDTO.setTenmh(ctHoadon.getCtMathang().getMathang().getTenmh());
		chitietMathangDTO.setMathangDTO(mathangDTO);
		chitietHoadonDTO.setChitietMathangDTO(chitietMathangDTO);
		chitietHoadonDTO.setGia(ctHoadon.getGia());
		chitietHoadonDTO.setSoluong(ctHoadon.getSoluong());
		return chitietHoadonDTO;
	}
	public CtHoadon toEntity(ChitietHoadonDTO chitietHoadonDTO) {
		CtHoadon ctHoadon=new CtHoadon();
		Hoadon hoadon=new Hoadon();
		hoadon.setMahd(chitietHoadonDTO.getHoadonDTO().getMahd());
		ctHoadon.setHoadon(hoadon);
		ctHoadon.setGia(chitietHoadonDTO.getGia());
		CtMathang ctMathang=new CtMathang();
		Mathang mathang=new Mathang();
		mathang.setMamh(chitietHoadonDTO.getChitietMathangDTO().getMathangDTO().getMamh());
		mathang.setTenmh(chitietHoadonDTO.getChitietMathangDTO().getMathangDTO().getTenmh());
		ctMathang.setMathang(mathang);
		ctMathang.setSize(chitietHoadonDTO.getChitietMathangDTO().getSize());
		ctMathang.setId(chitietHoadonDTO.getChitietMathangDTO().getId());
		ctMathang.setCurrentNumbeer(chitietHoadonDTO.getChitietMathangDTO().getCurrentNumbeer());
		ctMathang.setColor(chitietHoadonDTO.getChitietMathangDTO().getColor());
		
		ctHoadon.setCtMathang(ctMathang);
		ctHoadon.setSoluong(chitietHoadonDTO.getSoluong());
		CtHoadonId ctHoadonId=new CtHoadonId();
		ctHoadonId.setMahd(chitietHoadonDTO.getHoadonDTO().getMahd());
		ctHoadonId.setId(chitietHoadonDTO.getChitietMathangDTO().getId());
		ctHoadon.setId(ctHoadonId);
		return ctHoadon;
	}
}
