package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.repository.NhacungcapRepository;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.KhachhangDTO;
import com.example.demo.dto.NhacungcapDTO;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhacungcap;
import com.example.demo.service.NhacungcapService;

import net.bytebuddy.asm.Advice.Return;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NhacungcapController {
	@Autowired
	private NhacungcapService nhaccservice;
	@Autowired
	private NhacungcapRepository nhacungcapRepository;
	@Autowired
	private ModelMapper modelmapper;
	@GetMapping("/nhacungcap")
	public ResponseEntity<List<NhacungcapDTO>> getAllNhaCC(){
		List<NhacungcapDTO> nhacungcaps=nhaccservice.getAllNhaCC();
		if (nhacungcaps.isEmpty())
			return new ResponseEntity<List<NhacungcapDTO>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<NhacungcapDTO>>(nhacungcaps,HttpStatus.OK);			
	}
	@GetMapping("/nhacungcap/{id}")
	public ResponseEntity<Object> getNhaCCById(@PathVariable int id){
		Nhacungcap nhacungcap=nhaccservice.findById(id);
		if (nhacungcap == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nha cung cap khong ton tai", null));
		}	
		return new ResponseEntity<>(modelmapper.map(nhacungcap,NhacungcapDTO.class), HttpStatus.OK);
		
	}
//	@PostMapping("/nhacungcap")
//	public ResponseEntity<Object> createNhaCC(@RequestBody Nhacungcap nhacungcap){
//		nhaccservice.save(nhacungcap);
//		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "nha cung cap them thanh cong", nhacungcap));
//	}
	@PostMapping("/nhacungcap")
	public ResponseEntity<Object> saveNhaCC(@RequestBody NhacungcapDTO nhacungcapDTO) {
		try {
	if(!nhacungcapRepository.getNccByEmail(nhacungcapDTO.getEmail()).isEmpty())
		return ResponseEntity.ok(new ApiResponse(402, "Email nhà cung cấp đã tồn tại",null));
	if(!nhacungcapRepository.getNccBySdt(nhacungcapDTO.getSodt()).isEmpty())
		return ResponseEntity.ok(new ApiResponse(403, "Số điện thoại nhà cung cấp đã tồn tại",null));
	Nhacungcap nhacungcap = modelmapper.map(nhacungcapDTO, Nhacungcap.class);
	NhacungcapDTO nhacungcapDTO2 = nhaccservice.save(nhacungcap);
	return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Nha cung cap created successfully",
					nhacungcapDTO2));
		}
		catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(404, "Tên nhà cung cấp đã tồn tại",null));
		}
    }
	@PostMapping("/nhacungcaps")
	public ResponseEntity<Object> saveNhaCCList(@RequestBody List<NhacungcapDTO> nhacungcapDTOs){
		List<Nhacungcap> nhacungcaps=nhacungcapDTOs.stream().map(nhacungcap->modelmapper.map(nhacungcap, Nhacungcap.class)).collect(Collectors.toList());
		List<NhacungcapDTO> nhacungcapDTOs2	=nhaccservice.saveNhancungcaps(nhacungcaps);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Tat ca nha cung cap create successfully", nhacungcapDTOs2));
	}
	@PutMapping("/nhacungcap/{id}")
	public ResponseEntity<Object> updateNhaCC(@PathVariable int id,@RequestBody NhacungcapDTO nhacungcapDTO){
		Nhacungcap nhacungcap2=nhaccservice.findById(id);
		if (nhacungcap2==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Nha cung cap khong ton tai", null));
		}
		nhacungcapDTO.setMancc(id);
		Nhacungcap nhacungcap=modelmapper.map(nhacungcapDTO, Nhacungcap.class);
		NhacungcapDTO nhacungcapDTO2=nhaccservice.save(nhacungcap);
		
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Nha cung cap updated successfully ", nhacungcapDTO2));
	}
	@DeleteMapping("/nhacungcap/{id}")
	public ResponseEntity<Object> deleteNhaCC(@PathVariable int id){
		Nhacungcap nhacungcap=nhaccservice.findById(id);
		if (nhacungcap==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Nha cung cap khong ton tai",null));
		}
		return ResponseEntity.ok(nhaccservice.delete(id));
	}
}
