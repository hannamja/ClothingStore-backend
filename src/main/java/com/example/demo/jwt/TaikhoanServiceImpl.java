package com.example.demo.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Taikhoan;
import com.example.demo.repository.TaiKhoanRepository;

public class TaikhoanServiceImpl implements UserDetailsService {
	@Autowired private TaiKhoanRepository taiKhoanRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Taikhoan tk = taiKhoanRepository.findByEmail(username);
        
        if (tk == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        
        return new MyTaikhoanDetails(tk);
	}

}
