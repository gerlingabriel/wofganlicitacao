package com.sistema.wofganlicitacao.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String segredo;

    @Value("${jwt.expiration}")
    private Long tempoExpiracao;
    
    public String gerandoJWTToken(String cnpj){
        
        return Jwts.builder()
                .setSubject(cnpj)
                .setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao))
                .signWith(gerarCodificacao())
                .compact();
    }

    public String refreshTToken(String cnpj){
        
        return Jwts.builder()
                .setSubject(cnpj)
                .setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao * tempoExpiracao * 8))
                .signWith(gerarCodificacao())
                .compact();
    }

    public boolean tokenValido(String token) {

        Claims claims = getClaims(token);

        if (claims != null && claims.size() != 0) {
            String username = claims.getSubject();
            Date dataExparacao = claims.getExpiration();
            Date dataDeHoje = new Date(System.currentTimeMillis());
            
            if (username != null && dataExparacao != null && dataDeHoje.before(dataExparacao)) {
                return true;
            }
        }
        return false;
    }


    public String getUsername(String token) {
        Claims claims = getClaims(token);

        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    // Métodos privados
    private Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(gerarCodificacao()).build().parseClaimsJws(token).getBody() ;
        } catch (Exception e) {
            return Jwts.claims();
        }
        
    }

    private Key gerarCodificacao(){
        return new SecretKeySpec(Base64.getDecoder().decode(segredo), SignatureAlgorithm.HS512.getJcaName());
    }

    
}
