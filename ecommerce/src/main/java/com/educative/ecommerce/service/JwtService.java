package com.educative.ecommerce.service;

public interface JwtService {
    String getToken(String key, Object value);

//    Claims getClaims(String token);

    boolean isValid(String token);

    int getId(String token);
}