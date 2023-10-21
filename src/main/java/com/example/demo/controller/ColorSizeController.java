package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Color;
import com.example.demo.entity.Size;
import com.example.demo.service.ColorService;
import com.example.demo.service.SizeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ColorSizeController {
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	
	@GetMapping("/color")
	public List<Color> getColors() {
		return colorService.getColors();
	}
	
	@GetMapping("/size")
	public List<Size> getSizes() {
		return sizeService.getSizes();
	}
}
