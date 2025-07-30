package com.studys.button_backend.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String SECRET = "chave_muito_secreta";

    public static String gerarToken(int matricula, String tipo) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("tipo", tipo); // "admin" ou "common"

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(matricula))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1h
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}

