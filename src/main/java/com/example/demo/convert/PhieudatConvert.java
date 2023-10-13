package com.example.demo.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ColorDTO;
import com.example.demo.dto.CtPhieudatDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.NhacungcapDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.dto.SizeDTO;
import com.example.demo.entity.CtPhieudat;
import com.example.demo.entity.Nhacungcap;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Phieudat;
import com.example.demo.entity.Phieunhap;

@Component
public class PhieudatConvert {
	
	public PhieudatDTO toDTO(Phieudat phieudat, List<Phieunhap> pns, List<CtPhieudat> ctpds) {
		PhieudatDTO phieudatDTO = new PhieudatDTO();
		phieudatDTO.setMapd(phieudat.getMapd());
		phieudatDTO.setNgaydat(phieudat.getNgaydat());
		phieudatDTO.setNhacungcapDTO(new NhacungcapDTO(phieudat.getNhacungcap().getMancc(), phieudat.getNhacungcap().getTenncc()));
		NhanvienDTO nhanvienDTO=new NhanvienDTO();
		if (phieudat.getNhanvien()!=null && phieudat.getNhanvien().getManv()!=null) {
			nhanvienDTO.setManv(phieudat.getNhanvien().getManv());
			phieudatDTO.setNhanvienDTO(nhanvienDTO);
		}else {
			phieudatDTO.setNhanvienDTO(nhanvienDTO);
		}
		List<ImportDTO> phieunhapDTOs = new ArrayList<ImportDTO>();
		for(Phieunhap pn : pns) {
			phieunhapDTOs.add(new ImportDTO(pn.getMapn()));
		}
		phieudatDTO.setPhieunhapDTOs(phieunhapDTOs);
		
		List<CtPhieudatDTO> ctPhieudatDTOs = new ArrayList<CtPhieudatDTO>();
		for (CtPhieudat ctpd : ctpds) {
			CtPhieudatDTO temp = new CtPhieudatDTO();
			temp.setSoluong(ctpd.getSoluong());
			temp.setDongia(ctpd.getDongia());
			ColorDTO colorDTO = new ColorDTO(ctpd.getCtMathang().getColor().getMacolor(), ctpd.getCtMathang().getColor().getTencolor());
			SizeDTO sizeDTO = new SizeDTO(ctpd.getCtMathang().getSize().getMasize(),ctpd.getCtMathang().getSize().getTensize());
			temp.setCtMathangDTOs(new ChitietMathangDTO(ctpd.getCtMathang().getId(),colorDTO,sizeDTO, ctpd.getCtMathang().getCurrentNumbeer(),new MathangDTO(ctpd.getCtMathang().getMathang().getMamh(), ctpd.getCtMathang().getMathang().getTenmh())));
			ctPhieudatDTOs.add(temp);
		}
		phieudatDTO.setCtPhieudatDTOs(ctPhieudatDTOs);
		return phieudatDTO;
	}
	
	public Phieudat toEntiy(PhieudatDTO phieudatDTO) {
		Phieudat phieudat = new Phieudat();
		phieudat.setNhacungcap(new Nhacungcap(phieudatDTO.getNhacungcapDTO().getMancc()));
		phieudat.setMapd(phieudatDTO.getMapd());
		phieudat.setNgaydat(phieudatDTO.getNgaydat());
		phieudat.setNhanvien(new Nhanvien(phieudatDTO.getNhanvienDTO().getManv()));
		return phieudat;
	}
}
