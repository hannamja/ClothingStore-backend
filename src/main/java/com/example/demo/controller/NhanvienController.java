package com.example.demo.controller;

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
import com.example.demo.dto.NhanvienDTO;
import com.example.demo.dto.TaikhoanDTO;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Taikhoan;
import com.example.demo.repository.CtQuyenRepository;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.NhanvienService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NhanvienController {
	@Autowired
	private NhanvienService nhanvienService;
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@Autowired
	private CtQuyenRepository ctQuyenRepository;
	@Autowired
	private CtQConvert convert;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/nhanvien")
	public ResponseEntity<List<NhanvienDTO>> GetAllNhanvien(){
		List<NhanvienDTO> nhanvienDTOs=nhanvienService.getAllNhanvien();
		if (nhanvienDTOs.isEmpty()) {
			return new ResponseEntity<List<NhanvienDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NhanvienDTO>>(nhanvienDTOs,HttpStatus.OK);
	}
	@GetMapping("/nhanvien/{id}")
	public ResponseEntity<Object> getNhanvienById(@PathVariable int id){
		Nhanvien nhanvien=nhanvienService.getNhanvienById(id);
		if (nhanvien==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nhan vien khong ton tai", null));
		}
		return new ResponseEntity<>(modelMapper.map(nhanvien,NhanvienDTO.class), HttpStatus.OK);
	}
	@GetMapping("/nhanvien/search/{name}")
	public ResponseEntity<Object> getKHByName(@PathVariable("name") String name){
		
		List<NhanvienDTO> nhanvienDTOs=nhanvienService.getNhanvienByname(name);
		if (nhanvienDTOs.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nhan vien khong ton tai", null));
		}
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(),"Nhan vien khi tim la",nhanvienDTOs));
	}
	@PostMapping("/nhanvien")
	public ResponseEntity<Object> saveNhanvien(@RequestBody NhanvienDTO nhanvienDTO){
		Nhanvien nhanvien=modelMapper.map(nhanvienDTO, Nhanvien.class);
		if(taiKhoanRepository.findByEmail(nhanvienDTO.getEmail())!=null) {
			return ResponseEntity.ok(new ApiResponse(404, "Email tồn tại",null));
		}
		NhanvienDTO nhanvienDTO2=nhanvienService.save(nhanvien);
		
			Taikhoan tk = new Taikhoan();
			tk.setEmail(nhanvienDTO2.getEmail());
			tk.setMatkhau("123456789");
			tk.setNhanvien(nhanvien);
			Taikhoan tkSaved = taiKhoanRepository.save(tk);
			
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Nhan vien created successfully",
               nhanvienDTO2));
	}
	@PutMapping("/nhanvien/{id}")
	public ResponseEntity<Object> updateNhanvien(@RequestBody NhanvienDTO nhanvienDTO,@PathVariable int id){
		Nhanvien nhanvien=nhanvienService.getNhanvienById(id);
		if (nhanvien==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nhan vien khong ton tai", null));
		}
		nhanvienDTO.setManv(id);
		Nhanvien nhanvien2=modelMapper.map(nhanvienDTO, Nhanvien.class);
		NhanvienDTO nhanvienDTO2=nhanvienService.save(nhanvien2);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Nhan vien updated successfully ", nhanvienDTO2));
	}
	@DeleteMapping("/nhanvien/{id}")
	public ResponseEntity<Object> deleteNV(@PathVariable int id){
		Nhanvien nhanvien=nhanvienService.getNhanvienById(id);
		if (nhanvien==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nhan vien khong ton tai", null));
		}
		
		return ResponseEntity.ok(nhanvienService.delete(id));
	}
}
