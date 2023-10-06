package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ChatlieuDTO;
import com.example.demo.dto.LoaimhDTO;
import com.example.demo.entity.Chatlieu;
import com.example.demo.repository.ChatlieuRepository;
import com.example.demo.service.ChatlieuService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChatlieuController {
	@Autowired
	private ChatlieuService chatlieuService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("/chatlieu")
	public ResponseEntity<List<ChatlieuDTO>> getAllChatlieu(){
		List<ChatlieuDTO> chatlieuDTOs=chatlieuService.getAllChatlieu();
		if (chatlieuDTOs.isEmpty()) {
			return new ResponseEntity<List<ChatlieuDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ChatlieuDTO>>(chatlieuDTOs,HttpStatus.OK);
	}
	@PostMapping("/chatlieu")
	public ChatlieuDTO save(@RequestBody ChatlieuDTO chatlieuDTO) {
		return chatlieuService.save(modelMapper.map(chatlieuDTO, Chatlieu.class));
	}
	@GetMapping("/chatlieu/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Chatlieu chatlieu = chatlieuService.findById(id);
		if(chatlieu==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Chất liệu khong ton tai",null));
		}
		return  new ResponseEntity<>(modelMapper.map(chatlieu, ChatlieuDTO.class),HttpStatus.OK);
	}
	
	@DeleteMapping("/chatlieu/{id}")
	public ResponseEntity<Object> save(@PathVariable int id) {
		return ResponseEntity.ok(chatlieuService.delete(id));
	}
}
