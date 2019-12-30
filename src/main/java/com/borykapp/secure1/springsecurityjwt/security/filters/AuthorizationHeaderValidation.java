package com.borykapp.secure1.springsecurityjwt.security.filters;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationHeaderValidation {
    public boolean validate(String token) {
        return token != null && token.startsWith("Bearer ");
    }
}
