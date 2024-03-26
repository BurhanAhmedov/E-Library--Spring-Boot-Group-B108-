package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

/*  @Value("${token.signing.key}")
  private String jwtSigningKey;*/
  private SecretKey key;

  public JwtServiceImpl(){
    String signingKey = "413F4428472B4B6250655368566D5970337336763979244226452948404D6351";
    byte[] keyBytes = Base64.getDecoder().decode(signingKey.getBytes(StandardCharsets.UTF_8));
    this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
  }

  @Override
  public String extractUserName(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  @Override
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  @Override
  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String userName = extractUserName(token);
    return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
    return claimsResolvers.apply(
        Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());
  }

  private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts.builder()
        .claims(extraClaims)
        .subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 10))
        .signWith(key)
        .compact();
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }



}
