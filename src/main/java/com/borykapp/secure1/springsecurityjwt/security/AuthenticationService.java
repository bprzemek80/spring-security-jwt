package com.borykapp.secure1.springsecurityjwt.security;

import com.borykapp.secure1.springsecurityjwt.security.exception.SecurityCredentialException;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final SpringSecurityUserDetailsService springSecurityUserDetailsService;
    private final JwtService jwtService;

    public String getAuthenticationToken(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.warn("Can't authenticate user, invalid username or password!");
            throw new SecurityCredentialException(e.getMessage());
        }

        UserDetails userDetails = springSecurityUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        return jwtService.generateToken(userDetails);
    }
}
