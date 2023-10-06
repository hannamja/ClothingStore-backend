package com.example.demo.jwt;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import com.example.demo.entity.Taikhoan;
@Component
public class JwtUtils {
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
	private String SECRET_KEY = "most-secret-key-on-earth";
    
    public String generateAccessToken(Taikhoan taiKhoan) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", taiKhoan.getEmail(), taiKhoan.getMatkhau()))
                .setIssuer("demo")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
                 
    }
    
    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
          
        } catch (IllegalArgumentException ex) {
    
        } catch (MalformedJwtException ex) {
            
        } catch (UnsupportedJwtException ex) {
          
        } catch (SignatureException ex) {
           
        }
         
        return false;
    }
     
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }
     
    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
