package com.guimaraes.medicine.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.guimaraes.medicine.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;

@Service
public class TokenService {

    @Value("${spring.security.token.secret}")
    private String secret;

    public TokenDTO createToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456789");
            String token = JWT.create()
                    .withIssuer("api-medicine")
                    .withSubject(username)
                    .withExpiresAt(this.expiratironDate())
                    .sign(algorithm);
            return new TokenDTO(token);
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Error generating token", exception);
        }
    }

    public String validateToken(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456789");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("api-medicine")
                    .build();

            decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTCreationException("Error validate token", exception);
        }
    }



    private Instant expiratironDate(){
        Instant now = Instant.now().atZone(ZoneId.of("America/Sao_Paulo")).toInstant();
        Instant expiration = now.plusSeconds(60 * 60);
        return expiration;
    }
}
