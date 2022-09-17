package com.mezzoforte.greenstreet.global.lib;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.repository.UserRepository;
import com.mezzoforte.greenstreet.global.enums.JwtType;
import com.mezzoforte.greenstreet.global.error.exception.InvalidTokenException;
import com.mezzoforte.greenstreet.global.lib.encrypt.SHA512Encrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.*;

@Component
@RequiredArgsConstructor
public class Jwt {

    @Value("${jwt.secret.access}")
    private String secretAccessKey;

    @Value("${jwt.secret.access}")
    private String secretRefreshKey;

    private final SHA512Encrypt encrypt;
    private final SignatureAlgorithm signatureAlgorithm;
    private final UserRepository userRepository;

    public String createToken(User user, JwtType jwtType) {

        Date nowDate = new Date();
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.setTime(nowDate);

        String secretKey = "";

        switch(jwtType) {
            case ACCESS:
                expiredDate.add(Calendar.DATE, 3);
                secretKey = secretAccessKey;
            case REFRESH:
                expiredDate.add(Calendar.DATE, 20);
                secretKey = secretRefreshKey;
        }

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, encrypt.getEncryptMethodName());

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");
        headerMap.put("alg", encrypt.getEncryptMethodName());

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", user.getId());

        JwtBuilder builder = Jwts.builder().setHeaderParams(headerMap)
                .setClaims(claimsMap)
                .setExpiration(expiredDate.getTime())
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    public User validateToken(String token) {

        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretAccessKey)).parseClaimsJws(token).getBody();

        return userRepository.findById(claims.get("id", Long.class))
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
    }

    public String refresh(String refreshToken) {

        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretRefreshKey)).parseClaimsJws(refreshToken).getBody();
        User user = userRepository.findById(claims.get("id", Long.class))
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);

        return createToken(user, JwtType.ACCESS);
    }

    public String extract(HttpServletRequest request, String type) {

        Enumeration<String> headers = request.getHeaders("Authorization");

        while(headers.hasMoreElements()) {
            String value = headers.nextElement();
            if(value.toLowerCase().startsWith(type.toLowerCase())) {
                return value.substring(type.length()).trim();
            }
        }

        return null;
    }
}
