package com.pokorili.musicOn.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;


@Service
public class CryptService {

    public String getAuthToken(String email) {
        return Base64.encodeBase64String(email.getBytes());
    }
    public String decodeToken(String token) {
        return new String(Base64.decodeBase64(token));
    }
}
