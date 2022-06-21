package peaksoft.restapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generaToken(String email){
//        System.out.println("generate");
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
//        System.out.println("2324")
        return Jwts.builder().setSubject(email).setExpiration(date).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

    }

    public  boolean validateToken(String token){
        try {
//            System.out.println("validate");
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            System.out.println("end validate");
            return true;
        }catch (Exception e){
//            log.severe("invalid token");
            return false;
        }
    }
    public  String getEmailFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
