package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.DanhgiaDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.Binhluan;
import com.example.demo.entity.BinhluanId;
import com.example.demo.entity.Danhgia;
import com.example.demo.entity.DanhgiaId;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Taikhoan;

@Component
public class DanhgiaConvert {
	public DanhgiaDTO toDTO(Danhgia danhgia) {
		DanhgiaDTO danhgiaDTO = new DanhgiaDTO();
		danhgiaDTO.setNgaybl(danhgia.getId().getNgaydg());
		TaikhoanDTO taikhoanDTO=new TaikhoanDTO();
		taikhoanDTO.setMatk(danhgia.getTaikhoan().getMatk());
		taikhoanDTO.setEmail(danhgia.getTaikhoan().getEmail());
		danhgiaDTO.setTaikhoanDTO(taikhoanDTO);
		danhgiaDTO.setNumber(danhgia.getNumber());
		return danhgiaDTO;
	}
	public Danhgia toEntity(DanhgiaDTO danhgiaDTO) {
		Danhgia danhgia=new Danhgia();
		DanhgiaId danhgiaId=new DanhgiaId();
		danhgiaId.setMamh(danhgiaDTO.getMathangDTO().getMamh());
		danhgiaId.setMatk(danhgiaDTO.getTaikhoanDTO().getMatk());
		danhgiaId.setNgaydg(danhgiaDTO.getNgaybl());
		danhgia.setId(danhgiaId);
		Mathang mathang=new Mathang();
		mathang.setMamh(danhgiaDTO.getMathangDTO().getMamh());
		mathang.setTenmh(danhgiaDTO.getMathangDTO().getTenmh());
		danhgia.setMathang(mathang);
		danhgia.setNumber(danhgiaDTO.getNumber());
		Taikhoan taikhoan=new Taikhoan();
		taikhoan.setMatk(danhgiaDTO.getTaikhoanDTO().getMatk());
		danhgia.setTaikhoan(taikhoan);
		return danhgia;
	}
}
