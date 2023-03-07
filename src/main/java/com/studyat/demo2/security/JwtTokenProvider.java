package com.studyat.demo2.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${demo2.app.secret}")
    private String APP_SECRET;
    @Value("${demo2.app.expires.in}")
    private Long EXPİRES_İN;

    public String generateJwtToken(Authentication auth) {
        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
        Date expireDate = new Date(new Date().getTime() + EXPİRES_İN);
        return Jwts.builder().setSubject(Long.toString(userDetails.getId())).
                setIssuedAt(new Date()).setExpiration(expireDate).signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();

    }

    Long getUSerIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET)
                .parseClaimsJws(token).
                getBody();
        return Long.parseLong(claims.getSubject());
    }
    boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        }catch (SignatureException | MalformedJwtException|ExpiredJwtException|UnsupportedJwtException|IllegalArgumentException e){
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration=Jwts.parser().setSigningKey(APP_SECRET)
                .parseClaimsJws(token).
                getBody().getExpiration();
        return expiration.before(new Date());
    }

}
