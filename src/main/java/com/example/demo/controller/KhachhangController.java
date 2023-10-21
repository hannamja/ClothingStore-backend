package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.CtQConvert;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CtQuyenDTO;
import com.example.demo.dto.CtQuyenID;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.QuyenDTO;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhacungcap;
import com.example.demo.entity.Taikhoan;
import com.example.demo.repository.CtQuyenRepository;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.KhachhangService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class KhachhangController {
	@Autowired
	private KhachhangService khachhangService;
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@Autowired
	private CtQuyenRepository ctQuyenRepository;
	@Autowired
	private CtQConvert convert;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/khachhang")
	public ResponseEntity<List<KhachhangDTO>> getAllKH(){
		List<KhachhangDTO> khachhangs=khachhangService.getAllKH();
		if (khachhangs.isEmpty()) {
			return new ResponseEntity<List<KhachhangDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<KhachhangDTO>>(khachhangs,HttpStatus.OK);	
	}
	@GetMapping("/khachhang/{id}")
	public ResponseEntity<Object> getKHById(@PathVariable int id){
		Khachhang khachhang=khachhangService.findById(id);
		if (khachhang==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Khach hang khong ton tai", null));
		}
		return new ResponseEntity<>(modelMapper.map(khachhang,KhachhangDTO.class), HttpStatus.OK);
	}
	@GetMapping("/khachhang/search/{name}")
	public ResponseEntity<List<KhachhangDTO>> getKHByName(@PathVariable("name") String name){
		System.out.println(name);
		List<KhachhangDTO> khachhangDTOs=khachhangService.getKHByName(name);
		if (khachhangDTOs.isEmpty()) {
			return new ResponseEntity<List<KhachhangDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<KhachhangDTO>>(khachhangDTOs,HttpStatus.OK);
	}
	@PostMapping("/khachhang/{mk}")
	public ResponseEntity<Object> saveKH(@RequestBody KhachhangDTO khachhangDTO, @PathVariable String mk){
		Khachhang khachhang=modelMapper.map(khachhangDTO, Khachhang.class);
		if(taiKhoanRepository.findByEmail(khachhangDTO.getEmail())!=null) {
			return ResponseEntity.ok(new ApiResponse(404, "Email tồn tại",null));
		}
		KhachhangDTO khachhangDTO2=khachhangService.save(khachhang);
		Taikhoan tk = new Taikhoan();
		tk.setEmail(khachhangDTO2.getEmail());
		tk.setMatkhau(mk);
		tk.setKhachhang(khachhang);
		Taikhoan tkSaved = taiKhoanRepository.save(tk);
		CtQuyenDTO t = new CtQuyenDTO();
		t.setTaikhoan(new TaikhoanDTO(tkSaved.getMatk()));
		t.setId(new CtQuyenID(new Date(),3, tkSaved.getMatk()));
		ctQuyenRepository.save(convert.toEntity(t));
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Khach hang created successfully",
                khachhangDTO2));
	}
	@PostMapping("/khachhang-signup/{mk}")
	public ResponseEntity<Object> signup(@RequestBody KhachhangDTO khachhangDTO, @PathVariable String mk){
		Khachhang khachhang=modelMapper.map(khachhangDTO, Khachhang.class);
		if(taiKhoanRepository.findByEmail(khachhangDTO.getEmail())!=null) {
			return ResponseEntity.ok(new ApiResponse(404, "Email tồn tại",null));
		}
		KhachhangDTO khachhangDTO2=khachhangService.save(khachhang);
		Taikhoan tk = new Taikhoan();
		tk.setEmail(khachhangDTO2.getEmail());
		tk.setMatkhau(mk);
		tk.setKhachhang(khachhang);
		Taikhoan tkSaved = taiKhoanRepository.save(tk);
		CtQuyenDTO t = new CtQuyenDTO();
		t.setTaikhoan(new TaikhoanDTO(tkSaved.getMatk()));
		t.setId(new CtQuyenID(new Date(),3, tkSaved.getMatk()));
		t.setQuyen(new QuyenDTO(3, "USER"));
		try {
			t.setNgayend(new SimpleDateFormat("yy/mm/dd").parse("2100/01/01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctQuyenRepository.save(convert.toEntity(t));
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Khach hang created successfully",
                khachhangDTO2));
	}
	@PutMapping("/khachhang/{id}")
	public ResponseEntity<Object> updateKH(@RequestBody KhachhangDTO khachhangDTO,@PathVariable int id){
		Khachhang khachhang=khachhangService.findById(id);
		if (khachhang==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Khach hang khong ton tai", null));
		}
		khachhangDTO.setMakh(id);
		Khachhang khachhang2=modelMapper.map(khachhangDTO, Khachhang.class);
		KhachhangDTO khachhangDTO2=khachhangService.save(khachhang2);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Khach hang updated successfully ", khachhangDTO2));
	}
	@DeleteMapping("/khachhang/{id}")
	public ResponseEntity<Object> deleteKH(@PathVariable int id){
		Khachhang khachhang=khachhangService.findById(id);
		if (khachhang==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Khach hang khong ton tai",null));
		}
		khachhangService.delete(id);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(),"Khach hang delete successfully",null));
	}
	

}
