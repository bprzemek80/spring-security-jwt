package com.borykapp.secure1.springsecurityjwt.security;

import com.borykapp.secure1.springsecurityjwt.security.exception.SSUserNotFoundException;
import com.borykapp.secure1.springsecurityjwt.security.exception.SSWrongCredentialException;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final SpringSecurityUserDetailsService springSecurityUserDetailsService;
    private final JwtService jwtService;

    public String getAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new SSWrongCredentialException("Incorrect username or password");
        }

        UserDetails userDetails = springSecurityUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        return jwtService.generateToken(userDetails);
    }
}
