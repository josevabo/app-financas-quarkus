package com.josevabo.appfinancas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenDTO {
    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("id_token")
    String idToken;

    @JsonProperty("refresh_token")
    String refreshToken;

    @JsonProperty("expires_at")
    long expiresAtMillis;

    public TokenDTO(String accessToken, String idToken, String refreshToken, Date expiresAt) {
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.refreshToken = refreshToken;
        this.expiresAtMillis = expiresAt.getTime();
    }

    public TokenDTO(String accessToken, String idToken, String refreshToken, long expiresAtMillis) {
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.refreshToken = refreshToken;
        this.expiresAtMillis = expiresAtMillis;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpiresAtMillis() {
        return expiresAtMillis;
    }
}
class CustomDateSerializer extends StdSerializer<Date> {
    private static final long serialVersionUID = 1L;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public CustomDateSerializer() {
        this(null);
    }
    public CustomDateSerializer(Class<Date> t) {
        super(t);
    }
    @Override
    public void serialize(Date value,
                          JsonGenerator generator, SerializerProvider arg2) throws IOException {
        generator.writeString(formatter.format(value));
    }
}