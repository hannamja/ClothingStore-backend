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
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.HinhanhDTO;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.MathangDTO;
import com.example.demo.entity.Gia;
import com.example.demo.entity.GiaId;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.service.GiaService;
import com.example.demo.service.MathangService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MathangController {
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
		System.out.print(mathangDTOs.size());
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
			System.out.println(mathangDTO);
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
	public ResponseEntity<Object> saveMH(@RequestBody MathangDTO mathangDTO)throws IOException, InterruptedException{
		Double ProductBrand=0D;
		   Double Material=0D;
		   Double ProductionWay=0D;
		   if (mathangDTO.getCachlam().equals("HAND")) {
			   ProductionWay=1D;
		   }else {
			   ProductionWay=0.5D;
		   }
		   if (mathangDTO.getChatlieuDTO().getMacl()==1) {
			   Material=1D;
		   }else if (mathangDTO.getChatlieuDTO().getMacl()==2) {
			   Material=(2/3D);
		   }else {
			   Material=(1/3D);
		   }
		   
		   if (mathangDTO.getNhanhieuDTO().getManh()==1) {
			   ProductBrand=1D;
		   }else if (mathangDTO.getNhanhieuDTO().getManh()==2) {
			   ProductBrand=0.8D;
		   }else if (mathangDTO.getNhanhieuDTO().getManh()==3) {
			   ProductBrand=0.6D;
		   }else if (mathangDTO.getNhanhieuDTO().getManh()==4) {
			   ProductBrand=0.4D;
		   }else {
			   ProductBrand=0.2D;
		   }
		   String label2=  readPython.ReadPython(ProductBrand, Material, ProductionWay);
		   System.out.print(label2);
		   String label1="";
		   if (label2.equals("0")) {
			label1="BINH DAN";
		   }else if (label2.equals("1")) {
			   label1="TAM TRUNG";
		   }else {
			label1="CAO CAP";
		   }
		Date currentDate = new Date();

        // Đặt ngày cụ thể cho currentDate
        int year = 2023;
        int month = 9; // Tháng (0-11, 0 là tháng 1)
        int day = 27;
        currentDate.setYear(year - 1900);
        currentDate.setMonth(month - 1);
        currentDate.setDate(day);
        mathangDTO.setPhanloai(label1);
		MathangDTO mathangDTO2= mathangService.save(mathangDTO,1,currentDate);
		List<HinhanhDTO> hinhanhDTOs=mathangDTO.getHinhanhDTOs();
		
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Mat hang created successfully",
                mathangDTO2));
	}
	@PutMapping("/mathang/{id}")
	public ResponseEntity<Object> updateMH(@RequestBody MathangDTO mathangDTO,@PathVariable int id){
		 MathangDTO mathangDTO2=mathangService.findById(id);
		 if (mathangDTO2==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Mat hang khong ton tai", null));
		}
		mathangDTO.setMamh(id);
		Date currentDate = new Date();

        // Đặt ngày cụ thể cho currentDate
        int year = 2023;
        int month = 9; // Tháng (0-11, 0 là tháng 1)
        int day = 29;
        currentDate.setYear(year - 1900);
        currentDate.setMonth(month - 1);
        currentDate.setDate(day);

		MathangDTO mathangDTO3=mathangService.save(mathangDTO,1,currentDate);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Mat hang updated successfully ", mathangDTO3));
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
