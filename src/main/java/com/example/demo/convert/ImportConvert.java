package com.example.demo.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ColorDTO;
import com.example.demo.dto.CtPhieunhapDTO;
import com.example.demo.dto.CtPhieunhapIdDTO;
import com.example.demo.dto.ImportDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.dto.PhieudatDTO;
import com.example.demo.dto.SizeDTO;
import com.example.demo.entity.CtPhieunhap;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Phieudat;
import com.example.demo.entity.Phieunhap;

@Component
public class ImportConvert {
	@Autowired
	private ModelMapper modelMapper;
	public ImportDTO toDTO(Phieunhap phieunhap, List<CtPhieunhap> ctpns) {
		ImportDTO importDTO = new ImportDTO();
		importDTO.setMapn(phieunhap.getMapn());
		importDTO.setNgaynhap(phieunhap.getNgaynhap());
		
		importDTO.setPhieudatDTO(new PhieudatDTO(phieunhap.getPhieudat().getMapd(),phieunhap.getPhieudat().getNgaydat()));
		
		NhanvienDTO nhanvienDTO=new NhanvienDTO();
		if (phieunhap.getNhanvien()!=null && phieunhap.getNhanvien().getManv()!=null) {
			nhanvienDTO.setManv(phieunhap.getNhanvien().getManv());
			importDTO.setNhanvienDTO(nhanvienDTO);
		}else {
			importDTO.setNhanvienDTO(nhanvienDTO);
		}
	
		List<CtPhieunhapDTO> ctphieunhapDTOs = new ArrayList<CtPhieunhapDTO>();
		for(CtPhieunhap ctpn : ctpns) {
			CtPhieunhapDTO temp = new CtPhieunhapDTO();
			temp.setSoluong(ctpn.getSoluong());
			temp.setDongia(ctpn.getDongia());
			temp.setPhieunhapDTO(new ImportDTO(ctpn.getPhieunhap().getMapn()));
			ColorDTO colorDTO = new ColorDTO(ctpn.getCtMathang().getColor().getMacolor(), ctpn.getCtMathang().getColor().getTencolor());
			SizeDTO sizeDTO = new SizeDTO(ctpn.getCtMathang().getSize().getMasize(),ctpn.getCtMathang().getSize().getTensize());
			temp.setCtMathangDTO(new ChitietMathangDTO(ctpn.getCtMathang().getId(),colorDTO,sizeDTO, ctpn.getCtMathang().getCurrentNumbeer(),new MathangDTO(ctpn.getCtMathang().getMathang().getMamh(), ctpn.getCtMathang().getMathang().getTenmh())));
			ctphieunhapDTOs.add(temp);
		}
		importDTO.setCtPhieunhapDTOs(ctphieunhapDTOs);
		return importDTO;
	}
	
	public Phieunhap toEntity(ImportDTO importDTO) {
		Phieunhap phieunhap = new Phieunhap();
		phieunhap.setMapn(importDTO.getMapn());
		phieunhap.setNgaynhap(importDTO.getNgaynhap());
		phieunhap.setNhanvien(new Nhanvien(importDTO.getNhanvienDTO().getManv()));
		phieunhap.setPhieudat(new Phieudat(importDTO.getPhieudatDTO().getMapd()));
		return phieunhap;
	}
}
