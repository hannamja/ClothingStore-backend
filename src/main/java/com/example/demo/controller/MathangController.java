package com.example.demo.controller;

import java.io.IOException;
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

import com.example.demo.convert.MathangConvert;
import com.example.demo.dto.ApiRes;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.Gia;
import com.example.demo.entity.GiaId;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.errcode.ApiErrCode;
import com.example.demo.errcode.ApiErrCodeEnumMap;
import com.example.demo.service.GiaService;
import com.example.demo.service.MathangService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MathangController {
	@Autowired
	private ApiErrCodeEnumMap apiErr;
	@Autowired
	private MathangService  mathangService;
	@Autowired
	private MathangConvert mathangConvert;
	@Autowired
	private GiaService giaService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ReadPython readPython;
	@GetMapping("/mathang")
	public ResponseEntity<List<MathangDTO>> getAllMathang(){
		List<MathangDTO> mathangDTOs=mathangService.getAllMathang();
		if (mathangDTOs.isEmpty()) {
			return new ResponseEntity<List<MathangDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MathangDTO>>(mathangDTOs,HttpStatus.OK);
	}
	@GetMapping("/mathangAd")
	public ResponseEntity<List<MathangDTO>> getAllMathangAd(){
		List<MathangDTO> mathangDTOs=mathangService.getAllMathangAd();
		if (mathangDTOs.isEmpty()) {
			return new ResponseEntity<List<MathangDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MathangDTO>>(mathangDTOs,HttpStatus.OK);
	}
	@GetMapping("/mathang/getByLoai/{id}")
	public ResponseEntity<List<MathangDTO>> getAllMathangByLoai(@PathVariable int id){
		List<MathangDTO> mathangDTOs=mathangService.getAllMathangByLoai(id);
		if (mathangDTOs.isEmpty()) {
			return new ResponseEntity<List<MathangDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MathangDTO>>(mathangDTOs,HttpStatus.OK);
	}
	@GetMapping("/mathang/{id}")
	public ResponseEntity<Object> getMHById(@PathVariable int id){
		MathangDTO mathangDTO=mathangService.findById(id);
		if (mathangDTO==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Mat hang khong ton tai", null));
		}
//		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Khach hang id la",
//                mathangDTO));
		return new ResponseEntity<>(mathangDTO, HttpStatus.OK);
	}
	
	@GetMapping("/mathang/loai/{id}")
	public ResponseEntity<Object> getMHByLoai(@PathVariable int id){
		MathangDTO mathangDTO=mathangService.findById(id);
		if (mathangDTO==null) {
			System.out.println(mathangDTO);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Mat hang khong ton tai", null));
		}
//		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Khach hang id la",
//                mathangDTO));
		return new ResponseEntity<>(mathangDTO, HttpStatus.OK);
	}
	
	@GetMapping("/mathang/nhanhieu/{id}")
	public ResponseEntity<Object> getMHByNh(@PathVariable int id){
		MathangDTO mathangDTO=mathangService.findById(id);
		if (mathangDTO==null) {
			System.out.println(mathangDTO);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Mat hang khong ton tai", null));
		}
//		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Khach hang id la",
//                mathangDTO));
		return new ResponseEntity<>(mathangDTO, HttpStatus.OK);
	}
	
	@PostMapping("/mathang")
	public ApiRes saveMH(@RequestBody MathangDTO mathangDTO)throws IOException, InterruptedException{
		Date currentDate = new Date();
		List<HinhanhDTO> hinhanhDTOs=mathangDTO.getHinhanhDTOs();
		return mathangService.save(mathangDTO,1,currentDate);
	}
	@PutMapping("/mathang/{id}")
	public ApiRes updateMH(@RequestBody MathangDTO mathangDTO,@PathVariable int id){
		 MathangDTO mathangDTO2=mathangService.findById(id);
		 if (mathangDTO2==null) {
			 return new ApiRes(ApiErrCode.CONNECT_ERROR.toString(), apiErr.getApiErrCode().get(ApiErrCode.CONNECT_ERROR),null);
		}
		mathangDTO.setMamh(id);
		Date currentDate = new Date();
		return mathangService.save(mathangDTO,1,currentDate);
	}
	
	@DeleteMapping("/mathang/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		MathangDTO mathangDTO2=mathangService.findById(id);
		if (mathangDTO2==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Mat hang khong ton tai",null));
		}
		return ResponseEntity.ok().body(mathangService.delete(id));
	}

}
