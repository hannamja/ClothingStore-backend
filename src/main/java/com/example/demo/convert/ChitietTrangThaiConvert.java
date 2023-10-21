package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ChitietTrangThaiDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.TrangThaihdDTO;
import com.example.demo.entity.CtTrangthai;
import com.example.demo.entity.CtTrangthaiId;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Trangthaihd;

@Component
public class ChitietTrangThaiConvert {
	public ChitietTrangThaiDTO toDTO(CtTrangthai ctTrangthai) {
		ChitietTrangThaiDTO ChitietTrangThaiDTO=new ChitietTrangThaiDTO();
		ChitietTrangThaiDTO.setNgaytao(ctTrangthai.getNgaytao());
		HoadonDTO hoadonDTO=new HoadonDTO();
		hoadonDTO.setMahd(ctTrangthai.getHoadon().getMahd());
		KhachhangDTO khachhangDTO=new KhachhangDTO();
		khachhangDTO.setHotenkh(ctTrangthai.getHoadon().getKhachhang().getHotenkh());
		hoadonDTO.setKhachhang(khachhangDTO);
		hoadonDTO.setNgaytao(ctTrangthai.getHoadon().getNgaytao());
		ChitietTrangThaiDTO.setHoadonDTO(hoadonDTO);
		TrangThaihdDTO trangThaihdDTO=new TrangThaihdDTO();
		trangThaihdDTO.setMatthd(ctTrangthai.getTrangthaihd().getMatthd());
		trangThaihdDTO.setTrangthai(ctTrangthai.getTrangthaihd().getTrangthai());
		ChitietTrangThaiDTO.setTrangthai(trangThaihdDTO);
		return ChitietTrangThaiDTO;
	}
	public CtTrangthai toEntity(ChitietTrangThaiDTO chitietTrangThaiDTO) {
		CtTrangthai ctTrangthai=new CtTrangthai();
		ctTrangthai.setNgaytao(chitietTrangThaiDTO.getNgaytao());
		Hoadon hoadon=new Hoadon();
		hoadon.setMahd(chitietTrangThaiDTO.getHoadonDTO().getMahd());
		ctTrangthai.setHoadon(hoadon);
		Trangthaihd trangthaihd=new Trangthaihd();
		//trangthaihd.setMatthd(chitietTrangThaiDTO.get);
		//trangthaihd.setTrangthai(chitietTrangThaiDTO.getTrangthai());
		ctTrangthai.setTrangthaihd(trangthaihd);
		CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
		ctTrangthaiId.setMahd(chitietTrangThaiDTO.getHoadonDTO().getMahd());
		//ctTrangthaiId.setMatthd(chitietTrangThaiDTO.getTrangThaihdDTO().getMatthd());
		ctTrangthai.setId(ctTrangthaiId);
		return ctTrangthai;
	}
}
