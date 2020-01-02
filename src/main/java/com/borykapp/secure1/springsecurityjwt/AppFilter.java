package com.borykapp.secure1.springsecurityjwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class AppFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.warn("Remote host: [{}]", request.getRemoteHost());
        log.warn("Remote Address: [{}]", request.getRemoteAddr());

        chain.doFilter(request, response);
    }
}
