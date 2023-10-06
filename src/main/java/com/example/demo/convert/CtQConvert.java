package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CtQuyenDTO;
import com.example.demo.dto.CtQuyenID;
import com.example.demo.dto.QuyenDTO;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.CtQuyen;
import com.example.demo.entity.CtQuyenId;
import com.example.demo.entity.Quyen;
import com.example.demo.entity.Taikhoan;

@Component
public class CtQConvert {
	public CtQuyenDTO toDTO(CtQuyen ctq) {
		CtQuyenDTO CtQDTO = new CtQuyenDTO();
		CtQDTO.setId(new CtQuyenID(ctq.getId().getNgaystart(),ctq.getId().getMaquyen(),ctq.getId().getMatk()));
		CtQDTO.setNgayend(ctq.getNgayend());
		CtQDTO.setQuyen(new QuyenDTO(ctq.getQuyen().getMaquyen(), ctq.getQuyen().getTenquyen()));
		CtQDTO.setTaikhoan(new TaikhoanDTO(ctq.getTaikhoan().getMatk()));
		return CtQDTO;
	}
	public CtQuyen toEntity(CtQuyenDTO ctqDTO) {
		CtQuyen q = new CtQuyen();
		q.setNgayend(ctqDTO.getNgayend());
		q.setId(new CtQuyenId(ctqDTO.getId().getNgaystart(), ctqDTO.getId().getMaquyen(), ctqDTO.getId().getMatk()));
		q.setTaikhoan(new Taikhoan(ctqDTO.getTaikhoan().getMatk()));
		q.setQuyen(new Quyen(ctqDTO.getQuyen().getMaquyen()));
		return q;
	}
}
