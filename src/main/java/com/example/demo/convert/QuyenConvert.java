package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.QuyenDTO;
import com.example.demo.entity.Quyen;

@Component
public class QuyenConvert {
	public QuyenDTO toDTO(Quyen q) {
		return new QuyenDTO(q.getMaquyen(), q.getTenquyen());
	}
	public Quyen toEntity(QuyenDTO qDTO) {
		return new Quyen(qDTO.getMaquyen(),qDTO.getTenquyen());
	}
}
