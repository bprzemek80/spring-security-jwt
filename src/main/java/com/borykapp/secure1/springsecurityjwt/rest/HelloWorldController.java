package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.security.AuthenticationService;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationRequest;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final AuthenticationService authenticationService;

    @GetMapping("/hello")
    public String hello() {
        log.warn("Getting hello world");
        return "Hello World";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        log.warn("Post for authentication token for [{}]", authenticationRequest.getUserName());
        String authenticationToken = authenticationService.getAuthenticationToken(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(authenticationToken));
    }
}
