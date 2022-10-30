package com.example.onthigk.service;

import com.example.onthigk.model.User;
import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private final String JWT_SECRET_KEY = "nguyenthihao";
    private final long JWT_EXPIRATION = 546655625L;

    public String generateToken(User user) {
        Date dateNow = new Date();
        Date expDate = new Date(dateNow.getTime() + JWT_EXPIRATION);
        String token = Jwts.builder().setSubject(user.getId())
                .setIssuedAt(dateNow)
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }
}
