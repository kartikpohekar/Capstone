package com.example.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms}")
    private long exp;

    public String generateToken(String username, Long id){
        return Jwts.builder()
            .setSubject(username)
            .claim("id", id)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+exp))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean validate(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Long getId(String token){
        Claims c = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Object id = c.get("id");
        if(id instanceof Integer) return ((Integer)id).longValue();
        if(id instanceof Long) return (Long)id;
        return Long.parseLong(String.valueOf(id));
    }
}
