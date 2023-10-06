package com.example.demo.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.CtPhieunhapDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtPhieunhap;
import com.example.demo.entity.CtPhieunhapId;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Phieunhap;

@Component
public class CtPhieuNhapConvert {
	@Autowired
	private ModelMapper modelMapper;
	public CtPhieunhapDTO toDTO(CtPhieunhap ctpn) {
		CtPhieunhapDTO temp = new CtPhieunhapDTO();
		temp.setSoluong(ctpn.getSoluong());
		temp.setDongia(ctpn.getDongia());
		temp.setPhieunhapDTO(new ImportDTO(ctpn.getPhieunhap().getMapn()));
		temp.setCtMathangDTO(new ChitietMathangDTO(ctpn.getCtMathang().getId(),ctpn.getCtMathang().getColor(),ctpn.getCtMathang().getSize(), ctpn.getCtMathang().getCurrentNumbeer(),new MathangDTO(ctpn.getCtMathang().getMathang().getMamh(),ctpn.getCtMathang().getMathang().getTenmh())));
		return temp;
	}
	
	public CtPhieunhap toEntity(CtPhieunhapDTO ctpnDTO) {
		CtPhieunhap ctPhieunhap = new CtPhieunhap();
		ctPhieunhap.setSoluong(ctpnDTO.getSoluong());
		ctPhieunhap.setDongia(ctPhieunhap.getDongia());
		ctPhieunhap.setPhieunhap(new Phieunhap(ctpnDTO.getPhieunhapDTO().getMapn()));
		
		return ctPhieunhap;
	}
}
