package vn.com.gsoft.security.util.system;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    @Value("${jwt.token.validity:86400000}")
    private long validity;
    @Value("${jwt.refreshtoken.validity:604800000}")
    private long rtValidity;
    @Value("${jwt.secret}")
    private String secret;

    // Lấy tên người dùng từ token jwt
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // Lấy ngày hết hạn từ token jwt
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // Lấy thông tin từ token thông qua một hàm xử lý claims
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // Lấy tất cả các claims từ token jwt; cần secret key để giải mã
    public Claims getAllClaimsFromToken(String token) {
        String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.parser().setSigningKey(encodedString).parseClaimsJws(token).getBody();
    }

    // Kiểm tra xem token có hết hạn hay không
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Tạo token mới với dữ liệu đầu vào
    public String generateToken(String data) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "token");
        return doGenerateToken(claims, data, this.validity);
    }

    // Tạo refresh token mới với dữ liệu đầu vào
    public String generateRefreshToken(String data) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "refreshtoken");
        return doGenerateToken(claims, data, this.rtValidity);
    }

    // Thực hiện việc tạo token với các claims và thời gian hiệu lực
    private String doGenerateToken(Map<String, Object> claims, String subject, long validity) {
        String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS512, encodedString)
                .compact();
    }
}