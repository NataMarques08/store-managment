package com.nata.store_management_customers_and_products.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.nata.store_management_customers_and_products.config.JwtProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final long EXPIRATION_TIME_MS = 1000 * 60 * 60 * 24; // 24h

    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtService(JwtProperties jwtProperties) {
        // Inicializa o algoritmo com a chave secreta
        this.algorithm = Algorithm.HMAC256(jwtProperties.getSecret());
        this.verifier = JWT.require(algorithm).build();
    }

    public String generateToken(UserDetails userDetails) {
        long now = System.currentTimeMillis();
        return JWT.create()
                .withSubject(userDetails.getUsername())
                // Converte lista de authorities para String separados por vírgula
                .withClaim("authorities",
                        userDetails.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.joining(",")))
                .withIssuedAt(new Date(now))
                .withExpiresAt(new Date(now + EXPIRATION_TIME_MS))
                .sign(algorithm);
    }

    public String extractUsername(String token) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String username = decodedJWT.getSubject();
            Date expiresAt = decodedJWT.getExpiresAt();

            return (username.equals(userDetails.getUsername()) && expiresAt.after(new Date()));
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
