package edu.utexas.tacc.tapis.notifications.frontend;

import io.jsonwebtoken.*;

import java.security.PublicKey;
import java.util.Objects;

public class TapisJWTValidator {

    private final String encodedJWT;

    public TapisJWTValidator(String encodedJWT) {
        this.encodedJWT = encodedJWT;
    }

    public Jws<Claims> validate(PublicKey publicKey) throws JwtException {
        Jws<Claims> jwts = Jwts.parser()
            .setSigningKey(publicKey)
            .parseClaimsJws(encodedJWT);

        Claims claims = jwts.getBody();
        try {
            Objects.requireNonNull(claims.get(TapisClaims.TAPIS_TENANT));
            Objects.requireNonNull(claims.get(TapisClaims.TAPIS_USERNAME));
            Objects.requireNonNull(claims.get(TapisClaims.TAPIS_TOKEN_TYPE));
            Objects.requireNonNull(claims.get(TapisClaims.TAPIS_ACCOUNT_TYPE));
            Objects.requireNonNull(claims.get(TapisClaims.TAPIS_TARGET_SITE));
            if (claims.get(TapisClaims.TAPIS_DELEGATION) != null) {
                Objects.requireNonNull(claims.get(TapisClaims.TAPIS_DELEGATION_SUB));
            }
        } catch (NullPointerException ex) {
            throw new JwtException("Claims are not valid");
        }
        return jwts;

    }

    public Claims getClaimsNoValidation() {
        int i = encodedJWT.lastIndexOf('.');
        String withoutSignature = encodedJWT.substring(0, i+1);
        Jwt<?,Claims> untrusted = Jwts.parser()
            .parseClaimsJwt(withoutSignature);
        return untrusted.getBody();
    }




}
