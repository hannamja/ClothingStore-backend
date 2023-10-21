package com.example.demo.jwt;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Taikhoan;

public class MyTaikhoanDetails implements UserDetails {
	public Taikhoan tk;
	
	public MyTaikhoanDetails(Taikhoan tk) {
		this.tk = tk;
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
 
    @Override
    public String getPassword() {
        return tk.getMatkhau();
    }
 
    @Override
    public String getUsername() {
        return tk.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
