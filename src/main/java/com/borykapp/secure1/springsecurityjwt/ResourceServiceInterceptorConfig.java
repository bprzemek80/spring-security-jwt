package com.borykapp.secure1.springsecurityjwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@RequiredArgsConstructor
public class ResourceServiceInterceptorConfig implements WebMvcConfigurer {

    private final ResourceServiceInterceptor resourceServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resourceServiceInterceptor);
    }
}
