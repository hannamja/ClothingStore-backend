package com.example.demo.convert;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.dto.BinhluanDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.Binhluan;
import com.example.demo.entity.BinhluanId;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Taikhoan;

@Component
public class BinhluanConvert {
	public BinhluanDTO toDTO(Binhluan binhluan) {
		BinhluanDTO binhluanDTO=new BinhluanDTO();
		//Date date=new Date();
		binhluanDTO.setNgaybl(binhluan.getId().getNgaybl());
		binhluanDTO.setNoidung(binhluan.getNoidung());
		TaikhoanDTO taikhoanDTO=new TaikhoanDTO();
		taikhoanDTO.setMatk(binhluan.getTaikhoan().getMatk());
		taikhoanDTO.setEmail(binhluan.getTaikhoan().getEmail());
		binhluanDTO.setTaikhoanDTO(taikhoanDTO);
		return binhluanDTO;
	}
	public Binhluan toEntity(BinhluanDTO binhluanDTO) {
		Binhluan binhluan=new Binhluan();
		BinhluanId binhluanId=new BinhluanId();
		binhluanId.setMamh(binhluanDTO.getMathangDTO().getMamh());
		binhluanId.setMatk(binhluanDTO.getTaikhoanDTO().getMatk());
		binhluanId.setNgaybl(binhluanDTO.getNgaybl());
		binhluan.setId(binhluanId);
		binhluan.setNoidung(binhluanDTO.getNoidung());
		Taikhoan taikhoan=new Taikhoan();
		taikhoan.setMatk(binhluanDTO.getTaikhoanDTO().getMatk());
		binhluan.setTaikhoan(taikhoan);
		return binhluan;
	}
}
