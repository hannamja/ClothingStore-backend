package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ColorDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.SizeDTO;
import com.example.demo.entity.Color;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Size;

@Component
public class ChitietMathangConvert {
	public ChitietMathangDTO toDTO(CtMathang ctMathang) {
		ChitietMathangDTO chitietMathangDTO=new ChitietMathangDTO();
		chitietMathangDTO.setId(ctMathang.getId());
		chitietMathangDTO.setColorDTO(new ColorDTO(ctMathang.getColor().getMacolor(),ctMathang.getColor().getTencolor()));
		chitietMathangDTO.setSizeDTO(new SizeDTO(ctMathang.getSize().getMasize(),ctMathang.getSize().getTensize()));
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
		Color color = new Color(chitietMathangDTO.getColorDTO().getMacolor(), chitietMathangDTO.getColorDTO().getTencolor());
		Size size = new Size(chitietMathangDTO.getSizeDTO().getMasize(), chitietMathangDTO.getSizeDTO().getTensize());
		ctMathang.setColor(color);
		ctMathang.setSize(size);
		ctMathang.setCurrentNumbeer(chitietMathangDTO.getCurrentNumbeer());
		
		Mathang mathang=new Mathang();
		mathang.setMamh(chitietMathangDTO.getMathangDTO().getMamh());
		mathang.setTenmh(chitietMathangDTO.getMathangDTO().getTenmh());
		ctMathang.setMathang(mathang);
		return ctMathang;
	}
}
