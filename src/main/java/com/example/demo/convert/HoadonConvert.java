package com.example.demo.convert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ChitietTrangThaiDTO;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.dto.TrangThaihdDTO;
import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtTrangthai;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Trangthaihd;

@Component
public class HoadonConvert {
	@Autowired
	private ModelMapper modelMapper;
	public HoadonDTO toDTO(Hoadon hoadon,CtTrangthai ctTrangthai,List<CtHoadon> ctHoadon) {
		HoadonDTO hoadonDTO=new HoadonDTO();
		hoadonDTO.setMahd(hoadon.getMahd());
		hoadonDTO.setNgaytao(hoadon.getNgaytao());
		hoadonDTO.setTongtien(hoadon.getTongtien());
		KhachhangDTO khachhangDTO=new KhachhangDTO();
		khachhangDTO.setMakh(hoadon.getKhachhang().getMakh());
		khachhangDTO.setHotenkh(hoadon.getKhachhang().getHotenkh());
		khachhangDTO.setEmail(hoadon.getKhachhang().getEmail());
		hoadonDTO.setKhachhang(khachhangDTO);
		NhanvienDTO nhanvienDTO=new NhanvienDTO();
		if (hoadon.getNhanvien()!=null && hoadon.getNhanvien().getManv()!=null) {
			nhanvienDTO.setManv(hoadon.getNhanvien().getManv());
			hoadonDTO.setNhanvien(nhanvienDTO);
		}else {
			hoadonDTO.setNhanvien(nhanvienDTO);
		}
		ChitietTrangThaiDTO chitietTrangThaiDTO= new ChitietTrangThaiDTO();
		chitietTrangThaiDTO.setNgaytao(ctTrangthai.getNgaytao());
		TrangThaihdDTO trangThaihdDTO=new TrangThaihdDTO();
		trangThaihdDTO.setMatthd(ctTrangthai.getTrangthaihd().getMatthd());
		trangThaihdDTO.setTrangthai(ctTrangthai.getTrangthaihd().getTrangthai());
		chitietTrangThaiDTO.setTrangthai(trangThaihdDTO);
		HoadonDTO hoadonDTO3=new HoadonDTO();
		hoadonDTO3.setMahd(ctTrangthai.getHoadon().getMahd());
		chitietTrangThaiDTO.setHoadonDTO(hoadonDTO3);
		hoadonDTO.setChitietTrangThaiDTO(chitietTrangThaiDTO);
		
		List<ChitietHoadonDTO> chitietHoadonDTO=new ArrayList<ChitietHoadonDTO>();
		for(CtHoadon ctHoadon2:ctHoadon) {
			ChitietHoadonDTO chitietHoadonDTO2=new ChitietHoadonDTO();
			chitietHoadonDTO2.setGia(ctHoadon2.getGia());
			chitietHoadonDTO2.setSoluong(ctHoadon2.getSoluong());
			HoadonDTO hoadonDTO2=new HoadonDTO();
			hoadonDTO2.setMahd(ctHoadon2.getHoadon().getMahd());
			chitietHoadonDTO2.setHoadonDTO(hoadonDTO2);
			ChitietMathangDTO chitietMathangDTO2=new ChitietMathangDTO();
			chitietMathangDTO2.setColor(ctHoadon2.getCtMathang().getColor());
			chitietMathangDTO2.setCurrentNumbeer(ctHoadon2.getCtMathang().getCurrentNumbeer());
			chitietMathangDTO2.setId(ctHoadon2.getCtMathang().getId());
			chitietMathangDTO2.setSize(ctHoadon2.getCtMathang().getSize());
			MathangDTO mathangDTO2=new MathangDTO();
			mathangDTO2.setMamh(ctHoadon2.getCtMathang().getMathang().getMamh());
			mathangDTO2.setTenmh(ctHoadon2.getCtMathang().getMathang().getTenmh());
			
			List<HinhanhDTO> hinhanhDTOs = new ArrayList<HinhanhDTO>();
			for (Hinhanhmh ha : ctHoadon2.getCtMathang().getMathang().getHinhanhmhs()) {
				hinhanhDTOs.add(new HinhanhDTO(ha.getMaha(),ha.getDuongdan()));
			}
			mathangDTO2.setHinhanhDTOs(hinhanhDTOs);
			chitietMathangDTO2.setMathangDTO(mathangDTO2);
			chitietHoadonDTO2.setChitietMathangDTO(chitietMathangDTO2);
			chitietHoadonDTO.add(chitietHoadonDTO2);
		}
		hoadonDTO.setChitietHoadonDTO(chitietHoadonDTO);
		
		return hoadonDTO;
	}
	public Hoadon toEnity(HoadonDTO hoadonDTO) {
		Hoadon hoadon=new Hoadon();
		hoadon.setMahd(hoadonDTO.getMahd());
		hoadon.setNgaytao(hoadonDTO.getNgaytao());
		hoadon.setTongtien(hoadonDTO.getTongtien());
		Khachhang khachhang=new Khachhang();
		khachhang.setMakh(hoadonDTO.getKhachhang().getMakh());
		hoadon.setKhachhang(khachhang);
		Nhanvien nhanvien=new Nhanvien();
		nhanvien.setManv(hoadonDTO.getNhanvien().getManv());
		hoadon.setNhanvien(nhanvien);
		Set<CtTrangthai> ctTrangthai=new HashSet<CtTrangthai>();
		CtTrangthai ctTrangthai2=new CtTrangthai();
		Hoadon hoadon2=new Hoadon();
		hoadon2.setMahd(hoadonDTO.getMahd());
		ctTrangthai2.setHoadon(hoadon2);
		ctTrangthai2.setNgaytao(hoadonDTO.getChitietTrangThaiDTO().getNgaytao());
		Trangthaihd trangthaihd=new Trangthaihd();
		trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
		trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
		ctTrangthai2.setTrangthaihd(trangthaihd);
		ctTrangthai.add(ctTrangthai2);
		
		hoadon.setCtTrangthais(ctTrangthai);
		return hoadon;
	}
}
