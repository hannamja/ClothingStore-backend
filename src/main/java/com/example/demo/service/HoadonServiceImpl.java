package com.example.demo.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.ChitietHoadonConvert;
import com.example.demo.convert.HoadonConvert;
import com.example.demo.dto.ApiRes;
import com.example.demo.dto.ChitietHoadonDTO;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.CtTrangthai;
import com.example.demo.entity.CtTrangthaiId;
import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Trangthaihd;
import com.example.demo.errcode.ApiErrCode;
import com.example.demo.errcode.ApiErrCodeEnumMap;
import com.example.demo.repository.ChitietHoadonRepository;
import com.example.demo.repository.ChitietMathangRepository;
import com.example.demo.repository.ChitietTrangThaiRepository;
import com.example.demo.repository.HoadonRepository;

@Service
public class HoadonServiceImpl implements HoadonService {
	@Autowired
	private HoadonRepository hoadonRepository;
	@Autowired
	private HoadonConvert hoadonConvert;
	@Autowired
	private ChitietHoadonConvert chitietHoadonConvert;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ApiErrCodeEnumMap errCode;
	@Autowired
	private ChitietTrangThaiRepository chitietTrangThaiRepository;
	@Autowired 
	private ChitietHoadonRepository chitietHoadonRepository;
	@Autowired ChitietMathangRepository chitietMathangRepository;
	@Override
	public HoadonDTO save(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
		Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
		Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
		List<ChitietHoadonDTO> cthds = hoadonDTO.getChitietHoadonDTO();
		
		for (CtTrangthai trangthai : trangthais) {
	        // Thực hiện các thao tác với từng đối tượng CtTrangthai ở đây
	    }
		
		for (ChitietHoadonDTO cthd : cthds) {
			if(!checkTonKho(cthd)) return new HoadonDTO();
			
		}
		for (ChitietHoadonDTO cthd : cthds) {
			Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
			CtMathang mh = temp.get();
			if(Integer.parseInt(mh.getCurrentNumbeer())-cthd.getSoluong()<0) {
				return modelMapper.map(new Hoadon(), HoadonDTO.class);
			}
			mh.setCurrentNumbeer(String.valueOf(Integer.parseInt(mh.getCurrentNumbeer())-cthd.getSoluong()));
			chitietMathangRepository.save(mh);
		}
		Hoadon hoadon2=hoadonRepository.save(hoadon);
		CtTrangthai ctTrangthai=new CtTrangthai();
		ctTrangthai.setHoadon(hoadon2);
		Date currentDate = new Date();
		ctTrangthai.setNgaytao(currentDate);
		Trangthaihd trangthaihd=new Trangthaihd();
		trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
		trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
		ctTrangthai.setTrangthaihd(trangthaihd);
		CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
		ctTrangthaiId.setMahd(hoadon2.getMahd());
		ctTrangthaiId.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
		ctTrangthai.setId(ctTrangthaiId);
		chitietTrangThaiRepository.save(ctTrangthai);
		
		
		// Sử lí chi tiết hóa đơn
		CtHoadon ctHoadon=new CtHoadon();
		List<ChitietHoadonDTO> ctHoadons=hoadonDTO.getChitietHoadonDTO();
		List<CtHoadon> ctHoadons2=new ArrayList<CtHoadon>();
		for(ChitietHoadonDTO chitietHoadonDTO:ctHoadons) {
			HoadonDTO hoadonDTO2=new HoadonDTO();
			hoadonDTO2.setMahd(hoadon2.getMahd());
			chitietHoadonDTO.setHoadonDTO(hoadonDTO2);
			ctHoadons2.add(chitietHoadonConvert.toEntity(chitietHoadonDTO));
		}
		chitietHoadonRepository.saveAll(ctHoadons2);
		return modelMapper.map(hoadon2, HoadonDTO.class);
	}
	
	@Override
	public ApiRes cancel(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
		try {
			Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
			Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
			List<ChitietHoadonDTO> cthds = hoadonDTO.getChitietHoadonDTO();
			for (CtTrangthai trangthai : trangthais) {
		        // Thực hiện các thao tác với từng đối tượng CtTrangthai ở đây
		    }
			
			if(hoadonRepository.findById(hoadonDTO.getMahd()).isPresent()) {
				if(chitietTrangThaiRepository.getCT_TrangThai(hoadonDTO.getMahd()).getTrangthaihd().getMatthd()==6)
					return new ApiRes(ApiErrCode.BILL_CANCLED_FAIL.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_CANCLED_FAIL), null);;
			}
			for (ChitietHoadonDTO cthd : cthds) {
				Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
				CtMathang mh = temp.get();
				mh.setCurrentNumbeer(String.valueOf(Integer.parseInt(mh.getCurrentNumbeer())+cthd.getSoluong()));
				chitietMathangRepository.save(mh);
			}
			Hoadon hoadon2=hoadonRepository.save(hoadon);
			CtTrangthai ctTrangthai=new CtTrangthai();
			ctTrangthai.setHoadon(hoadon2);
			Date currentDate = new Date();
			ctTrangthai.setNgaytao(currentDate);
			Trangthaihd trangthaihd=new Trangthaihd();
			trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
			trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
			ctTrangthai.setTrangthaihd(trangthaihd);
			CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
			ctTrangthaiId.setMahd(hoadon2.getMahd());
			ctTrangthaiId.setMatthd(6);
			ctTrangthai.setId(ctTrangthaiId);
			chitietTrangThaiRepository.save(ctTrangthai);
			
			return new ApiRes(ApiErrCode.BILL_CANCELED_SUCCESS.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_CANCELED_SUCCESS), modelMapper.map(hoadon2,HoadonDTO.class));
		}
		catch(Exception e) {
			return new ApiRes(ApiErrCode.BILL_CANCLED_FAIL.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_CANCLED_FAIL), null);
		}
	}
	
	@Override
	public List<HoadonDTO> getAllHoadon() {
		// TODO Auto-generated method stub
		List<Hoadon> hoadons=hoadonRepository.findAll();
		List<HoadonDTO> hoadonDTOs=new ArrayList<HoadonDTO>();
		for(Hoadon hoadon:hoadons) {
			hoadonDTOs.add(hoadonConvert.toDTO(hoadon,chitietTrangThaiRepository.getCT_TrangThai(hoadon.getMahd()),chitietHoadonRepository.getCT_Hoadon(hoadon.getMahd())));
		}
		return hoadonDTOs;
	}
	
	
	public boolean checkTonKho(ChitietHoadonDTO cthd) {
		Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
		if(Integer.parseInt(temp.get().getCurrentNumbeer()) < cthd.getSoluong()) return false;
		return true;
	}

	@Override
	public HoadonDTO updateTT(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
				Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
				Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
				Hoadon hoadon2=hoadonRepository.save(hoadon);
				CtTrangthai ctTrangthai=new CtTrangthai();
				ctTrangthai.setHoadon(hoadon2);
				Date currentDate = new Date();
				ctTrangthai.setNgaytao(currentDate);
				Trangthaihd trangthaihd=new Trangthaihd();
				trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
				trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
				ctTrangthai.setTrangthaihd(trangthaihd);
				CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
				ctTrangthaiId.setMahd(hoadon2.getMahd());
				ctTrangthaiId.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
				ctTrangthai.setId(ctTrangthaiId);
				chitietTrangThaiRepository.save(ctTrangthai);
				
				return modelMapper.map(hoadon2, HoadonDTO.class);
	}

	@Override
	public HoadonDTO findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Hoadon> hoadon = hoadonRepository.findById(id);
		if(!hoadon.isPresent()) return null;
		Hoadon hoadon2 = hoadon.get();
		
		return hoadonConvert.toDTO(hoadon2,chitietTrangThaiRepository.getCT_TrangThai(hoadon2.getMahd()),chitietHoadonRepository.getCT_Hoadon(hoadon2.getMahd()));
	}

	@Override
	public ApiRes confirm(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
		try {
			Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
			Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
			List<ChitietHoadonDTO> cthds = hoadonDTO.getChitietHoadonDTO();
			for (CtTrangthai trangthai : trangthais) {
		        // Thực hiện các thao tác với từng đối tượng CtTrangthai ở đây
		    }
			for (ChitietHoadonDTO cthd : cthds) {
				Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
				CtMathang mh = temp.get();
				mh.setCurrentNumbeer(String.valueOf(Integer.parseInt(mh.getCurrentNumbeer())+cthd.getSoluong()));
				chitietMathangRepository.save(mh);
			}
			Hoadon hoadon2=hoadonRepository.save(hoadon);
			CtTrangthai ctTrangthai=new CtTrangthai();
			ctTrangthai.setHoadon(hoadon2);
			Date currentDate = new Date();
			ctTrangthai.setNgaytao(currentDate);
			Trangthaihd trangthaihd=new Trangthaihd();
			trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
			trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
			ctTrangthai.setTrangthaihd(trangthaihd);
			CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
			ctTrangthaiId.setMahd(hoadon2.getMahd());
			ctTrangthaiId.setMatthd(3);
			ctTrangthai.setId(ctTrangthaiId);
			chitietTrangThaiRepository.save(ctTrangthai);
			
			return new ApiRes(ApiErrCode.BILL_CONFIRMED_SUCCESS.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_CONFIRMED_SUCCESS), modelMapper.map(hoadon2,HoadonDTO.class));
		}
		catch(Exception e) {
			return new ApiRes(ApiErrCode.BILL_CONFIRMED_FAIL.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_CONFIRMED_FAIL), null);
		}
	}

	@Override
	public ApiRes complete(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
		try {
			Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
			Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
			List<ChitietHoadonDTO> cthds = hoadonDTO.getChitietHoadonDTO();
			for (CtTrangthai trangthai : trangthais) {
		        // Thực hiện các thao tác với từng đối tượng CtTrangthai ở đây
		    }
			for (ChitietHoadonDTO cthd : cthds) {
				Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
				CtMathang mh = temp.get();
				mh.setCurrentNumbeer(String.valueOf(Integer.parseInt(mh.getCurrentNumbeer())+cthd.getSoluong()));
				chitietMathangRepository.save(mh);
			}
			Hoadon hoadon2=hoadonRepository.save(hoadon);
			CtTrangthai ctTrangthai=new CtTrangthai();
			ctTrangthai.setHoadon(hoadon2);
			Date currentDate = new Date();
			ctTrangthai.setNgaytao(currentDate);
			Trangthaihd trangthaihd=new Trangthaihd();
			trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
			trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
			ctTrangthai.setTrangthaihd(trangthaihd);
			CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
			ctTrangthaiId.setMahd(hoadon2.getMahd());
			ctTrangthaiId.setMatthd(5);
			ctTrangthai.setId(ctTrangthaiId);
			chitietTrangThaiRepository.save(ctTrangthai);
			
			return new ApiRes(ApiErrCode.BILL_COMPLETED_DELIVERING.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_COMPLETED_DELIVERING), modelMapper.map(hoadon2,HoadonDTO.class));
		}
		catch(Exception e) {
			return new ApiRes(ApiErrCode.BILL_FAIL_TO_DELIVERY.toString(),errCode.getApiErrCode().get(ApiErrCode.BILL_FAIL_TO_DELIVERY), null);
		}
	}

	@Override
	public HoadonDTO processing(HoadonDTO hoadonDTO) {
		// TODO Auto-generated method stub
		Hoadon hoadon=hoadonConvert.toEnity(hoadonDTO);
		Set<CtTrangthai> trangthais=hoadon.getCtTrangthais();
		List<ChitietHoadonDTO> cthds = hoadonDTO.getChitietHoadonDTO();
		for (CtTrangthai trangthai : trangthais) {
	        // Thực hiện các thao tác với từng đối tượng CtTrangthai ở đây
	    }
		for (ChitietHoadonDTO cthd : cthds) {
			Optional<CtMathang> temp = chitietMathangRepository.findById(cthd.getChitietMathangDTO().getId());
			CtMathang mh = temp.get();
			mh.setCurrentNumbeer(String.valueOf(Integer.parseInt(mh.getCurrentNumbeer())+cthd.getSoluong()));
			chitietMathangRepository.save(mh);
		}
		Hoadon hoadon2=hoadonRepository.save(hoadon);
		CtTrangthai ctTrangthai=new CtTrangthai();
		ctTrangthai.setHoadon(hoadon2);
		Date currentDate = new Date();
		ctTrangthai.setNgaytao(currentDate);
		Trangthaihd trangthaihd=new Trangthaihd();
		trangthaihd.setMatthd(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getMatthd());
		trangthaihd.setTrangthai(hoadonDTO.getChitietTrangThaiDTO().getTrangthai().getTrangthai());
		ctTrangthai.setTrangthaihd(trangthaihd);
		CtTrangthaiId ctTrangthaiId=new CtTrangthaiId();
		ctTrangthaiId.setMahd(hoadon2.getMahd());
		ctTrangthaiId.setMatthd(4);
		ctTrangthai.setId(ctTrangthaiId);
		chitietTrangThaiRepository.save(ctTrangthai);
		
		return modelMapper.map(hoadon2, HoadonDTO.class);
	}
	
}
