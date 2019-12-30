package com.borykapp.secure1.springsecurityjwt.security;

import com.borykapp.secure1.springsecurityjwt.security.exception.SSUserNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {

    private Set<User> inMemoryDatabase = new HashSet<>();

    {
        inMemoryDatabase.add(new User("admin", "admin123", Collections.emptyList()));
        inMemoryDatabase.add(new User("demo", "demo123", Collections.emptyList()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return inMemoryDatabase.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new SSUserNotFoundException(format("User not found: [%s]", username)));
    }
}
