package com.example.ProjektB.config;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value( "${app.jwt.secret}" )
    private String jwtSecret;

    public String generateToken( String username ) {
        Instant now = Instant.now();
        Instant expiration = now.plus( 7, ChronoUnit.DAYS );

        return Jwts.builder().setSubject( username ).setIssuedAt( Date.from( now ) ).setExpiration( Date.from( expiration ) )
                .signWith( SignatureAlgorithm.HS512, jwtSecret ).compact();
    }

    public String generateToken( Authentication authentication ) {
        CustomUserDetails userDetails = ( CustomUserDetails ) authentication.getPrincipal();
        return generateToken( userDetails.getUsername() );
    }

    public String getUserNameFromToken( String token ) {
        Claims claims = Jwts.parser().setSigningKey( jwtSecret ).parseClaimsJws( token ).getBody();

        return claims.getSubject();
    }

    public boolean validateToken( String token ) {
        try {
            Jwts.parser().setSigningKey( jwtSecret ).parseClaimsJws( token );
            return true;
        } catch ( SignatureException e ) {
            log.error( e.toString() );
        } catch ( MalformedJwtException e ) {
            log.error( e.toString() );
        } catch ( ExpiredJwtException e ) {
            log.error( e.toString() );
        } catch ( UnsupportedJwtException e ) {
            log.error( e.toString() );
        } catch ( IllegalArgumentException e ) {
            log.error( e.toString() );
        }
        return false;
    }

}
