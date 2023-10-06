package com.example.demo.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.entity.Mathang;

@Component
public class HinhanhConvert {
	public HinhanhDTO toDTO(Hinhanhmh hinhanhmh) {
		HinhanhDTO hinhanhDTO=new HinhanhDTO();
		hinhanhDTO.setMaha(hinhanhmh.getMaha());
		hinhanhDTO.setDuongdan(hinhanhmh.getDuongdan());
		MathangDTO mathangDTO=new MathangDTO();
		mathangDTO.setMamh(hinhanhmh.getMathang().getMamh());
		mathangDTO.setTenmh(hinhanhmh.getMathang().getTenmh());
		hinhanhDTO.setMathangDTO(mathangDTO);
		return hinhanhDTO;
	}
	public Hinhanhmh toEntity(HinhanhDTO hinhanhDTO) {
		Hinhanhmh hinhanhmh=new Hinhanhmh();
		hinhanhmh.setMaha(hinhanhDTO.getMaha());
		hinhanhmh.setDuongdan(hinhanhDTO.getDuongdan());
		Mathang mathang=new Mathang();
		mathang.setMamh(hinhanhDTO.getMathangDTO().getMamh());	
		hinhanhmh.setMathang(mathang);
		return hinhanhmh;
	}
}
