package com.example.demo.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.BinhluanDTO;
import com.example.demo.dto.ChatlieuDTO;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.CtKhuyenmaiDTO;
import com.example.demo.dto.DanhgiaDTO;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.NhanhieuDTO;
import com.example.demo.entity.Binhluan;
import com.example.demo.entity.Chatlieu;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtKhuyenmaiId;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Danhgia;
import com.example.demo.entity.Gia;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.entity.Loaimh;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanhieu;

@Component
public class MathangConvert {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BinhluanConvert binhluanConvert;
	@Autowired
	private DanhgiaConvert danhgiaConvert;
	public MathangDTO toDTO(Mathang mathang,Gia gia,List<Hinhanhmh> hinhanhmh,List<CtMathang> ctMathangs, List<Binhluan> binhluan, List<Danhgia> danhgia, CtKhuyenmai ctkm ) {
		MathangDTO mathangDTO=new MathangDTO();
		mathangDTO.setMamh(mathang.getMamh());
		mathangDTO.setCachlam(mathang.getCachlam());
		mathangDTO.setMota(mathang.getMota());
		mathangDTO.setPhanloai(mathang.getPhanloai());
		mathangDTO.setTenmh(mathang.getTenmh());
		mathangDTO.setTrangthai(mathang.getTrangthai());
		ChatlieuDTO chatlieuDTO=new ChatlieuDTO();
		chatlieuDTO.setMacl(mathang.getChatlieu().getMacl());
		chatlieuDTO.setTenvai(mathang.getChatlieu().getTenvai());
		LoaimhDTO loaimhDTO=new LoaimhDTO();
		loaimhDTO.setMaloaimh(mathang.getLoaimh().getMaloaimh());
		loaimhDTO.setTenloadimh(mathang.getLoaimh().getTenloadimh());
		NhanhieuDTO nhanhieuDTO=new NhanhieuDTO();
		nhanhieuDTO.setManh(mathang.getNhanhieu().getManh());
		nhanhieuDTO.setTennh(mathang.getNhanhieu().getTennh());
		mathangDTO.setChatlieuDTO(chatlieuDTO);
		mathangDTO.setLoaimhDTO(loaimhDTO);
		mathangDTO.setNhanhieuDTO(nhanhieuDTO);
		if(gia == null) mathangDTO.setGia(0);
		else mathangDTO.setGia(gia.getGia());
		List<HinhanhDTO> hinhanhDTOs=new ArrayList<HinhanhDTO>();
		hinhanhDTOs=  hinhanhmh.stream().map(hinhanh->modelMapper.map(hinhanh, HinhanhDTO.class)).collect(Collectors.toList());
		mathangDTO.setHinhanhDTOs(hinhanhDTOs);
		List<ChitietMathangDTO> chitietMathangDTOs=new ArrayList<ChitietMathangDTO>();
		chitietMathangDTOs=ctMathangs.stream().map(ctmathang->modelMapper.map(ctmathang, ChitietMathangDTO.class)).collect(Collectors.toList());
		mathangDTO.setCtMathangs(chitietMathangDTOs);
		List<BinhluanDTO> binhluanDTOs= new ArrayList<BinhluanDTO>();
		for(Binhluan bl : binhluan) {
			binhluanDTOs.add(binhluanConvert.toDTO(bl));
		}
		mathangDTO.setBinhluans(binhluanDTOs);
		List<DanhgiaDTO> danhgiaDTOs= new ArrayList<DanhgiaDTO>(); 
		for(Danhgia dg : danhgia) {
			danhgiaDTOs.add(danhgiaConvert.toDTO(dg));
		}
		mathangDTO.setDanhgias(danhgiaDTOs);
		if(ctkm==null) mathangDTO.setChitietKhuyenmaiDTO(null);
		else mathangDTO.setChitietKhuyenmaiDTO(new CtKhuyenmaiDTO(new CtKhuyenmaiId(ctkm.getId().getMakm(), ctkm.getId().getMamh()),ctkm.getNgaybd(),ctkm.getNgaykt(),ctkm.getMucgiam()));
		
		return mathangDTO;
	}
	public Mathang toEntity(MathangDTO mathangDTO) {
		Mathang mathang=new Mathang();
		mathang.setMamh(mathangDTO.getMamh());
		mathang.setCachlam(mathangDTO.getCachlam());
		mathang.setMota(mathangDTO.getMota());
		mathang.setPhanloai(mathangDTO.getPhanloai());
		mathang.setTenmh(mathangDTO.getTenmh());
		mathang.setTrangthai(mathangDTO.getTrangthai());
		Chatlieu chatlieu=new Chatlieu();
		chatlieu.setMacl(mathangDTO.getChatlieuDTO().getMacl());
		chatlieu.setTenvai(mathangDTO.getChatlieuDTO().getTenvai());
		mathang.setChatlieu(chatlieu);
		Loaimh loaimh=new Loaimh();
		loaimh.setMaloaimh(mathangDTO.getLoaimhDTO().getMaloaimh());
		loaimh.setTenloadimh(mathangDTO.getLoaimhDTO().getTenloadimh());
		mathang.setLoaimh(loaimh);
		Nhanhieu nhanhieu=new Nhanhieu();
		nhanhieu.setManh(mathangDTO.getNhanhieuDTO().getManh());
		nhanhieu.setTennh(mathangDTO.getNhanhieuDTO().getTennh());
		mathang.setNhanhieu(nhanhieu);
		
		return mathang;
	}
}
