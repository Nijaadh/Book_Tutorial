package com.electron.electron.Util;

import com.electron.electron.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "jwt-secret/by_Nijaadh20#!@";

    private  String token;
    private Long expireDuration = 3600000L;
    public String generateJwtToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expireDuration); // Token expires after 24 hours


      //create Claims (payload)
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate);


    //Optional clims
        claims.put("type",user.getUserType());
        claims.put("name",user.getName());
        claims.put("email",user.getEmailid());


        // Generate the JWT token
        token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();

        return token;
    }
}
