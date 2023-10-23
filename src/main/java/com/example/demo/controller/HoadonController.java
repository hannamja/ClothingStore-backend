package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiRes;
import com.example.demo.dto.HoadonDTO;
import com.example.demo.entity.Hoadon;
import com.example.demo.service.HoadonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class HoadonController {
	@Autowired
	private HoadonService hoadonService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/hoadon")
	public List<HoadonDTO> getAllHoadon(){
		return hoadonService.getAllHoadon();
	}
	@GetMapping("/hoadon/{id}")
	public HoadonDTO getById(@PathVariable int id){
		return hoadonService.findById(id);
	}
	@GetMapping("/hoadonOfUser/{id}")
	public List<HoadonDTO> getByIdUser(@PathVariable int id){
		List<HoadonDTO> temp = hoadonService.getAllHoadon();
		List<HoadonDTO> kq = new ArrayList<HoadonDTO>();
		temp.forEach(t -> {
			if(t.getKhachhang().getMakh()==id) kq.add(t);
		});
		return kq;
	}
	@PostMapping("/hoadon")
	public HoadonDTO saveHoadon(@RequestBody HoadonDTO hoadonDTO) {
		return hoadonService.save(hoadonDTO);
	}
	
//	@PostMapping("/hoadon/cancel")
//	public HoadonDTO cancelHoadon(@RequestBody HoadonDTO hoadonDTO) {
//		return hoadonService.cancel(hoadonDTO);
//	}
	
	@PostMapping("/hoadon/cancel")
	public ApiRes cancelHoadon(@RequestBody HoadonDTO hoadonDTO) {
		return hoadonService.cancel(hoadonDTO);
	}
	
//	@PostMapping("/hoadon/confirm")
//	public HoadonDTO confirmHoadon(@RequestBody HoadonDTO hoadonDTO) {
//		return hoadonService.confirm(hoadonDTO);
//	}
	
	@PostMapping("/hoadon/confirm")
	public ApiRes confirmHoadon(@RequestBody HoadonDTO hoadonDTO) {
		return hoadonService.confirm(hoadonDTO);
	}
	
	@PostMapping("/hoadon/processing")
	public ApiRes processingHoadon(@RequestBody HoadonDTO hoadonDTO) {
		return hoadonService.processing(hoadonDTO);
	}
	
//	@PostMapping("/hoadon/complete")
//	public HoadonDTO completeHoadon(@RequestBody HoadonDTO hoadonDTO) {
//		return hoadonService.complete(hoadonDTO);
//	}
	
	@PostMapping("/hoadon/complete")
	public ApiRes completeHoadon(@RequestBody HoadonDTO hoadonDTO) {
		return hoadonService.complete(hoadonDTO);
	}
}
