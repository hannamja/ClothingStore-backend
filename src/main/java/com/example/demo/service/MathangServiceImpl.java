package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.BinhluanConvert;
import com.example.demo.convert.ChitietMathangConvert;
import com.example.demo.convert.DanhgiaConvert;
import com.example.demo.convert.HinhanhConvert;
import com.example.demo.convert.MathangConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ChitietMathangDTO;
import com.example.demo.dto.ColorDTO;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.dto.SizeDTO;
import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Gia;
import com.example.demo.entity.GiaId;
import com.example.demo.entity.Hinhanhmh;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.repository.BinhluanRepository;
import com.example.demo.repository.ChitietHoadonRepository;
import com.example.demo.repository.ChitietMathangRepository;
import com.example.demo.repository.CtKhuyenmaiRepository;
import com.example.demo.repository.DanhgiaRepository;
import com.example.demo.repository.GiaRepository;
import com.example.demo.repository.HinhanhRepository;
import com.example.demo.repository.MathangRepository;

@Service
public class MathangServiceImpl implements MathangService {
	@Autowired
	private MathangRepository mathangRepository;
	@Autowired
	private MathangConvert mathangConvert;
	@Autowired
	private ChitietMathangConvert chitietMathangConvert;
	@Autowired
	private GiaRepository giaRepository;
	@Autowired
	private HinhanhRepository hinhanhRepository;
	@Autowired
	private ChitietMathangRepository chitietMathangRepository;
	@Autowired
	private BinhluanRepository binhluanRepository;
	@Autowired
	private DanhgiaRepository danhgiaRepository;

	@Autowired
	private CtKhuyenmaiRepository ctKhuyenmaiRepository;
	@Autowired
	private ChitietHoadonRepository chitietHoadonRepository;

	@Autowired
	private ChitietMathangService chitietMathangService;
	@Autowired
	private HinhanhConvert hinhanhConvert;
	@Autowired
	private BinhluanConvert binhluanConvert;
	@Autowired
	private DanhgiaConvert danhgiaConvert;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<MathangDTO> getAllMathang() {
		// TODO Auto-generated method stub
		List<Mathang> list = mathangRepository.findAll();
		List<MathangDTO> mathangDTOs = new ArrayList<MathangDTO>();
		for (Mathang mh : list) {
			List<CtKhuyenmai> temp = ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh());
			if (mh.getTrangthai().equals("0"))
				if (temp.size() == 0)
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							null));
				else
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh()).get(0)));
		}
		return mathangDTOs;
	}

	@Override
	public List<MathangDTO> getAllMathangByLoai(Integer id) {
		// TODO Auto-generated method stub
		List<Mathang> list = mathangRepository.getMathangByLoai(id);
		List<MathangDTO> mathangDTOs = new ArrayList<MathangDTO>();
		for (Mathang mh : list) {
			List<CtKhuyenmai> temp = ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh());
			if (mh.getTrangthai().equals("0"))
				if (temp.size() == 0)
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							null));
				else
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh()).get(0)));
		}
		return mathangDTOs;
	}

	@Override
	public List<MathangDTO> getAllMathangByNh(Integer id) {
		// TODO Auto-generated method stub
		List<Mathang> list = mathangRepository.getMathangByNh(id);
		List<MathangDTO> mathangDTOs = new ArrayList<MathangDTO>();
		for (Mathang mh : list) {
			List<CtKhuyenmai> temp = ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh());
			if (mh.getTrangthai().equals("0"))
				if (temp.size() == 0)
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							null));
				else
					mathangDTOs.add(mathangConvert.toDTO(mh, giaRepository.getBanggiaLast(mh.getMamh()),
							hinhanhRepository.getHAByMH(mh.getMamh()),
							chitietMathangRepository.getCTMathang(mh.getMamh()),
							binhluanRepository.getBinhluan(mh.getMamh()), danhgiaRepository.getDanhgia(mh.getMamh()),
							ctKhuyenmaiRepository.getKhuyenmai(mh.getMamh()).get(0)));
		}
		return mathangDTOs;
	}

	@Override
	public MathangDTO findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Mathang> liMathang = mathangRepository.findById(id);

		Optional<MathangDTO> maOptional = liMathang.map(mathang -> {
			Gia gia = giaRepository.getBanggiaLast(id);
			List<Hinhanhmh> hinhanh = hinhanhRepository.getHAByMH(id);
			List<CtMathang> ctMathangs = chitietMathangRepository.getCTMathang(id);
			List<CtKhuyenmai> temp = ctKhuyenmaiRepository.getKhuyenmai(id);
			if (temp.size() == 0)
				return mathangConvert.toDTO(mathang, gia, hinhanh, ctMathangs, binhluanRepository.getBinhluan(id),
						danhgiaRepository.getDanhgia(id), null);
			else
				return mathangConvert.toDTO(mathang, gia, hinhanh, ctMathangs, binhluanRepository.getBinhluan(id),
						danhgiaRepository.getDanhgia(id), temp.get(0));
		});
		return maOptional.orElse(null);
	}

	@Override
	public MathangDTO save(MathangDTO mathangDTO, Integer id, Date date1) {
		// TODO Auto-generated method stub
		Mathang mathang = mathangConvert.toEntity(mathangDTO);
		Mathang mathang2 = mathangRepository.save(mathang);
		Gia gia = new Gia();
		gia.setGia(mathangDTO.getGia());
		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManv(id);
		gia.setNhanvien(nhanvien);
		gia.setMathang(mathang2);
		GiaId giaId = new GiaId();
		giaId.setMamh(mathang2.getMamh());
		giaId.setManv(id);
		Date date = new Date();
		giaId.setNgayapdung(date);
		gia.setId(giaId);
		gia.setNgaykt(date1);
		Gia temp = new Gia();
		temp = giaRepository.getBanggiaLast(mathang.getMamh());
		if (temp != null) {
			if (temp.getNgaykt().compareTo(new Date()) >= 0) {
				System.out.println(temp.getMathang().getTenmh());
				try {
					giaRepository.delete(temp);
					giaRepository.save(gia);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print("Lỗi giá");
				}
			}
			;
		}
		giaRepository.save(gia);
		// mathangDTO.setMamh(mathang2.getMamh());

		List<HinhanhDTO> hinhanhDTOs = mathangDTO.getHinhanhDTOs();
		List<Hinhanhmh> hinhanhmhs = new ArrayList<Hinhanhmh>();
		for (HinhanhDTO hinhanhDTO : hinhanhDTOs) {
			MathangDTO mathangDTO2 = new MathangDTO();
			mathangDTO2.setMamh(mathang2.getMamh());
			hinhanhDTO.setMaha(hinhanhDTO.getMaha());
			hinhanhDTO.setMathangDTO(mathangDTO2);
			hinhanhmhs.add(hinhanhConvert.toEntity(hinhanhDTO));
		}
		hinhanhRepository.saveAll(hinhanhmhs);

		List<CtMathang> mhs = new ArrayList<CtMathang>();
		for (ChitietMathangDTO mhDTO : mathangDTO.getCtMathangs()) {
			ChitietMathangDTO ctmhDTO = new ChitietMathangDTO();
			MathangDTO temp1 = new MathangDTO();
			temp1.setMamh(mathang2.getMamh());
			ctmhDTO.setMathangDTO(temp1);
			ctmhDTO.setSizeDTO(new SizeDTO(mhDTO.getSizeDTO().getMasize(), mhDTO.getSizeDTO().getTensize()));
			ctmhDTO.setColorDTO(new ColorDTO(mhDTO.getColorDTO().getMamau(), mhDTO.getColorDTO().getMamau()));
			ctmhDTO.setCurrentNumbeer(mhDTO.getCurrentNumbeer());
			mhs.add(chitietMathangConvert.toEntity(ctmhDTO));
		}
		if (chitietMathangService.getCtMathang(mathangDTO.getMamh()) != null) {
			List<CtMathang> ctMathangs = chitietMathangRepository.getCTMathang(mathangDTO.getMamh());
			chitietMathangRepository.deleteAll(ctMathangs);
		}
		chitietMathangRepository.saveAll(mhs);
		return modelMapper.map(mathang2, MathangDTO.class);
	}

	@Override
	public ApiResponse delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Mathang> temp = mathangRepository.findById(id);
		if(!temp.isPresent()) {
			return new ApiResponse(404, "Id không hợp lệ", null);
		}
		List<CtMathang> list = chitietMathangRepository.getCTMathang(id);
		Gia list1 = giaRepository.getBanggiaLast(id);
		if(list.size()==0 && chitietMathangService.getCtMathang(id).size() == 0 && list1==null) {
			mathangRepository.deleteById(id);
			return new ApiResponse(200, "Thành công", null);
		}
		else {
			Mathang temp1 = temp.get();
			temp1.setTrangthai("1");
			mathangRepository.save(temp1);
			return new ApiResponse(200, "Thành công", null);
		}
	}

}
