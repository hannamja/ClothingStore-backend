package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Mathang;

@Component
public class ChitietMathangConvert {
	public ChitietMathangDTO toDTO(CtMathang ctMathang) {
		ChitietMathangDTO chitietMathangDTO=new ChitietMathangDTO();
		chitietMathangDTO.setId(ctMathang.getId());
		chitietMathangDTO.setColor(ctMathang.getColor());
		chitietMathangDTO.setSize(ctMathang.getSize());
		chitietMathangDTO.setCurrentNumbeer(ctMathang.getCurrentNumbeer());
		MathangDTO mathangDTO=new MathangDTO();
		mathangDTO.setMamh(ctMathang.getMathang().getMamh());
		mathangDTO.setTenmh(ctMathang.getMathang().getTenmh());
		chitietMathangDTO.setMathangDTO(mathangDTO);
		return chitietMathangDTO;
	}
	public CtMathang toEntity(ChitietMathangDTO chitietMathangDTO) {
		CtMathang ctMathang=new CtMathang();
		ctMathang.setId(chitietMathangDTO.getId());
		ctMathang.setColor(chitietMathangDTO.getColor());
		ctMathang.setSize(chitietMathangDTO.getSize());
		ctMathang.setCurrentNumbeer(chitietMathangDTO.getCurrentNumbeer());
		Mathang mathang=new Mathang();
		mathang.setMamh(chitietMathangDTO.getMathangDTO().getMamh());
		mathang.setTenmh(chitietMathangDTO.getMathangDTO().getTenmh());
		ctMathang.setMathang(mathang);
		return ctMathang;
	}
}
