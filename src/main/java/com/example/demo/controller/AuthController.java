package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.AuthResponse;
import com.example.demo.entity.CtQuyen;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Quyen;
import com.example.demo.entity.Taikhoan;
import com.example.demo.jwt.CustomEncoder;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.jwt.MyTaikhoanDetails;
import com.example.demo.repository.TaiKhoanRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtUtils jwtUtil;
	@Autowired
	TaiKhoanRepository repo;

	@GetMapping("/insertUser")
	public ResponseEntity<?> insert() {

		Taikhoan newUser = new Taikhoan("hung@gmail", new CustomEncoder().encode("123456"));
		Taikhoan savedUser = repo.save(newUser);

		return ResponseEntity.ok().body(savedUser);
	}

	@PostMapping("/auth/signin")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

			MyTaikhoanDetails tk = (MyTaikhoanDetails) authentication.getPrincipal();

			String accessToken = jwtUtil.generateAccessToken(tk.tk);
			AuthResponse response = new AuthResponse(tk.tk.getEmail(), accessToken);
			response.setMatk(tk.tk.getMatk());
			List<CtQuyen> ctQuyens = new ArrayList<CtQuyen>();
			if(tk.tk.getNhanvien() == null) {
				response.setNhanvien(null);
				}
			else {
				Nhanvien nv = new Nhanvien();
				nv.setManv(tk.tk.getNhanvien().getManv());
				nv.setTennv(tk.tk.getNhanvien().getTennv());
				response.setNhanvien(nv);
			} 
			if(tk.tk.getKhachhang() == null) {
				response.setKhachhang(null);
				}
			else {
				Khachhang kh = new Khachhang();
				kh.setMakh(tk.tk.getKhachhang().getMakh());
				response.setKhachhang(kh);
			}
			for (CtQuyen ctq : tk.tk.getCtQuyens()) {
				CtQuyen temp = new CtQuyen();
				temp.setQuyen(new Quyen(ctq.getQuyen().getMaquyen()));
				temp.setNgayend(ctq.getNgayend());
				if(ctq.getNgayend().compareTo(new Date())>=0) ctQuyens.add(temp);
				
			}
			response.setCtQuyens(ctQuyens);
			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
