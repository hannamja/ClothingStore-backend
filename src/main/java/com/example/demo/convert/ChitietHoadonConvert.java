package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ColorDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.SizeDTO;
import com.example.demo.entity.Color;
import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtHoadonId;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Size;

@Component
public class ChitietHoadonConvert {
	public ChitietHoadonDTO toDTO(CtHoadon ctHoadon) {
		ChitietHoadonDTO chitietHoadonDTO=new ChitietHoadonDTO();
		HoadonDTO hoadonDTO=new HoadonDTO();
		hoadonDTO.setMahd(ctHoadon.getHoadon().getMahd());
		chitietHoadonDTO.setHoadonDTO(hoadonDTO);
		ChitietMathangDTO chitietMathangDTO=new ChitietMathangDTO();
		chitietMathangDTO.setId(ctHoadon.getCtMathang().getId());
		chitietMathangDTO.setColorDTO(new ColorDTO(ctHoadon.getCtMathang().getColor().getMacolor(),ctHoadon.getCtMathang().getColor().getTencolor()));
		chitietMathangDTO.setCurrentNumbeer(ctHoadon.getCtMathang().getCurrentNumbeer());
		chitietMathangDTO.setSizeDTO(new SizeDTO(ctHoadon.getCtMathang().getSize().getMasize(), ctHoadon.getCtMathang().getSize().getTensize()));
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
		ctMathang.setSize(new Size(chitietHoadonDTO.getChitietMathangDTO().getSizeDTO().getMasize() ,chitietHoadonDTO.getChitietMathangDTO().getSizeDTO().getTensize()));
		ctMathang.setId(chitietHoadonDTO.getChitietMathangDTO().getId());
		ctMathang.setCurrentNumbeer(chitietHoadonDTO.getChitietMathangDTO().getCurrentNumbeer());
		ctMathang.setColor(new Color(chitietHoadonDTO.getChitietMathangDTO().getColorDTO().getMacolor(),chitietHoadonDTO.getChitietMathangDTO().getColorDTO().getTencolor()));
		
		ctHoadon.setCtMathang(ctMathang);
		ctHoadon.setSoluong(chitietHoadonDTO.getSoluong());
		CtHoadonId ctHoadonId=new CtHoadonId();
		ctHoadonId.setMahd(chitietHoadonDTO.getHoadonDTO().getMahd());
		ctHoadonId.setId(chitietHoadonDTO.getChitietMathangDTO().getId());
		ctHoadon.setId(ctHoadonId);
		return ctHoadon;
	}
}
