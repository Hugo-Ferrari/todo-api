package hugo.todo_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION = 1000 * 60 * 60 * 24; // 24 horas

    public String gerarToken(String username) {
        return Jwts.builder().subject(username).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + EXPIRATION)).signWith(secretKey).compact();
    }

    public String extrairUsername(String token) {
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secretKey.getEncoded())).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validarToken(String token) {
        try {
            extrairUsername(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}