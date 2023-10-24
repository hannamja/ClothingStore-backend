package com.example.demo.controller;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.AuthResponse;
import com.example.demo.entity.CtQuyen;
import com.example.demo.entity.Khachhang;
import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Quyen;
import com.example.demo.entity.Taikhoan;
import com.example.demo.errcode.ApiErrCode;
import com.example.demo.errcode.ApiErrCodeEnumMap;
import com.example.demo.jwt.CustomEncoder;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.jwt.MyTaikhoanDetails;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.EmailSenderService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {
  @Autowired ApiErrCodeEnumMap apiErr;
  @Autowired AuthenticationManager authManager;
  @Autowired JwtUtils jwtUtil;
  @Autowired TaiKhoanRepository repo;

  @Autowired EmailSenderService senderService;

  private static Map<String, String> forgotPasswordMap = new HashMap<>();

  @GetMapping("/apiErrCode")
  public ResponseEntity<?> apiErrCode() {
    return ResponseEntity.ok().body(apiErr.getApiErrCode().get(ApiErrCode.SAVE_SUCCESS));
  }

  @GetMapping("/insertUser")
  public ResponseEntity<?> insert() {

    Taikhoan newUser = new Taikhoan("hung@gmail", new CustomEncoder().encode("123456"));
    Taikhoan savedUser = repo.save(newUser);

    return ResponseEntity.ok().body(savedUser);
  }

  @PostMapping("/auth/signin")
  public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    try {
      Authentication authentication =
          authManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

      MyTaikhoanDetails tk = (MyTaikhoanDetails) authentication.getPrincipal();

      String accessToken = jwtUtil.generateAccessToken(tk.tk);
      AuthResponse response = new AuthResponse(tk.tk.getEmail(), accessToken);
      response.setMatk(tk.tk.getMatk());
      List<CtQuyen> ctQuyens = new ArrayList<CtQuyen>();
      if (tk.tk.getNhanvien() == null) {
        response.setNhanvien(null);
      } else {
        Nhanvien nv = new Nhanvien();
        nv.setManv(tk.tk.getNhanvien().getManv());
        nv.setTennv(tk.tk.getNhanvien().getTennv());
        response.setNhanvien(nv);
      }
      if (tk.tk.getKhachhang() == null) {
        response.setKhachhang(null);
      } else {
        Khachhang kh = new Khachhang();
        kh.setMakh(tk.tk.getKhachhang().getMakh());
        kh.setDiachi(tk.tk.getKhachhang().getDiachi());
        response.setKhachhang(kh);
      }
      for (CtQuyen ctq : tk.tk.getCtQuyens()) {
        CtQuyen temp = new CtQuyen();
        temp.setQuyen(new Quyen(ctq.getQuyen().getMaquyen()));
        temp.setNgayend(ctq.getNgayend());
        if (ctq.getNgayend().compareTo(new Date()) >= 0) ctQuyens.add(temp);
      }
      response.setCtQuyens(ctQuyens);
      return ResponseEntity.ok().body(response);

    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

  @GetMapping("/auth/check-email-exist")
  public ResponseEntity<Integer> checkEmail(
      @RequestParam("email") String email, @RequestParam("isCreateOTP") Boolean isCreateOTP) {
    Taikhoan tk = repo.findByEmail(email);
    if (tk != null) {
      if (tk.getMatk() != null) {
        if (isCreateOTP) {
          double otpNumber = Math.random() * 100000;
          String otp = String.valueOf((int) otpNumber);
          AuthController.forgotPasswordMap.put(email, otp);
          senderService.sendEmail(
              email,
              "Mã OTP quên mật khẩu",
              "OTP để thay đổi mật khẩu mới cho tài khoản " + tk.getEmail() + " là: " + otp);
        } 
          return ResponseEntity.ok(tk.getMatk());
        
      }
    }
    return ResponseEntity.ok(0);
  }

  @GetMapping("/auth/check-email-and-otp")
  public ResponseEntity<Boolean> checkEmailAndOTP(
      @RequestParam("email") String email, @RequestParam("otp") String otp) {
    if (AuthController.forgotPasswordMap.containsKey(email)) {
      String otpInMap = AuthController.forgotPasswordMap.get(email);
      if (otpInMap.equals(otp)) {
        return ResponseEntity.ok(true);
      }
    }
    return ResponseEntity.ok(false);
  }

  @PostMapping("/auth/change-password-no-old-password")
  public ResponseEntity<Map<String, String>> changePasswordNoOldPassword(
      @RequestParam Integer accountId, @RequestParam String newPassword) {
    Map<String, String> returnedMap = new HashMap<>();
    
    Taikhoan tk = repo.findById(accountId).get();
    if (tk != null) {
      tk.setMatkhau(newPassword);
      repo.save(tk);
    } else returnedMap.put("error", "Id tài khoản không tồn tại");
    return ResponseEntity.ok(returnedMap);
  }
}
