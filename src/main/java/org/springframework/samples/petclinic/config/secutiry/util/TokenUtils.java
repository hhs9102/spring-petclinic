package org.springframework.samples.petclinic.config.secutiry.util;


import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.samples.petclinic.model.User;

import javax.xml.bind.DatatypeConverter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class TokenUtils {

    private static final String typ = "JWT";
    private static final String secretKey = "HAMHOSIK";

    public static boolean isValidToken(String token){
        try{
            Claims claims = getClaimsFromToken(token);
            log.info("expireTime :" + claims.getExpiration());
            log.info("username :" + claims.get("username"));
            log.info("role :" + claims.get("role"));
            return true;
        }catch (ExpiredJwtException exception) {
            log.error("Token Expired");
            return false;
        } catch (JwtException exception) {
            log.error("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            log.error("Token is null");
            return false;
        }
    }

    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
            .parseClaimsJws(token).getBody();

    }

    public static String generateJwtToken(User user){
        JwtBuilder builder = Jwts.builder()
            .setSubject(user.getUsername())
            .setHeader(createHeader())
            .setClaims(createClaims(user))
            .setExpiration(createExpireDate())
            .signWith(SignatureAlgorithm.HS256, secretKey);

        return builder.compact();
    }

    private static Date createExpireDate() {
        LocalDateTime expiredDate = LocalDateTime.now().plusMonths(1);
        return Date.from(expiredDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("role", user.getAuthorities());
        return claims;
    }

    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", typ);
        header.put("alg", SignatureAlgorithm.HS256.name());
        header.put("regDate", System.currentTimeMillis());
        return header;
    }
}
