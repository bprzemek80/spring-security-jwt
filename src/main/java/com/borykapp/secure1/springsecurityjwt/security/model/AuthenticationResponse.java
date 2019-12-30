package com.borykapp.secure1.springsecurityjwt.security.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
}
