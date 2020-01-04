package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.security.AuthenticationService;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationRequest;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestV1Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        log.warn("Post for authentication token for [{}]", authenticationRequest.getUserName());
        String authenticationToken = authenticationService.getAuthenticationToken(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(authenticationToken));
    }
}
