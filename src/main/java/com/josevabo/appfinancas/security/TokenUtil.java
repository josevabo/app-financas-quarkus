package com.josevabo.appfinancas.security;

import com.josevabo.appfinancas.dto.TokenDTO;
import com.josevabo.appfinancas.model.Usuario;
import io.smallrye.jwt.auth.principal.DefaultJWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.InternalServerErrorException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@ApplicationScoped
public class TokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtil.class);
    @Inject
    DefaultJWTParser parser;

    @ConfigProperty(name = "mp.jwt.verify.publickey.location")
    String pubKeyFileName; // Default "publicKey.pem"

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;
    public TokenDTO generateTokenForUser(Usuario usuario) throws ParseException{
        String accessToken = Jwt
                .issuer(issuer)
                .upn(usuario.getNome())
                .claim(Claims.full_name.name(), usuario.getNomeCompleto())
                .sign();

        String idToken = Jwt
                .issuer(issuer)
                .upn(usuario.getNome())
                .claim(Claims.full_name.name(), usuario.getNome())
                .claim(Claims.email.name(), usuario.getEmail())
//                .claim(Claims.birthdate.name(), dataNasc.orElse("null"))
                .sign();
        String refreshToken = Jwt
                .issuer(issuer)
                .upn(usuario.getNome())
                .sign();

        long expiresAt = parser.parse(accessToken).getExpirationTime();

        return new TokenDTO(accessToken, idToken, refreshToken, expiresAt);
    }


    public JsonWebToken verify(String token) throws ParseException {
        PublicKey publicKey = getPublicKeyFromClassPath(pubKeyFileName);
        JsonWebToken tokenDecoded = parser.verify(token, publicKey);
        LOGGER.info("Verified token: " + tokenDecoded.toString());

        return tokenDecoded;
    }

    private PublicKey getPublicKeyFromClassPath(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream pubKeyinputStream = classLoader.getResourceAsStream(fileName);
            String pubKeyString = readFromInputStream(pubKeyinputStream);
            return toPublicKey(pubKeyString);
        } catch (Exception e) {
            throw new InternalServerErrorException("Chave pública não encontrada/ não pode ser lida");
        }

    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static PublicKey toPublicKey(String pubKeyString) {
        PublicKey pubKey = null;
        pubKeyString = pubKeyString.replace("\n", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");
        try {
            byte[] publicBytes = Base64.getDecoder().decode(pubKeyString);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            pubKey = keyFactory.generatePublic(keySpec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pubKey;
    }
}
