package com.borykapp.secure1.springsecurityjwt.rest;

import com.borykapp.secure1.springsecurityjwt.domain.quote.QuoteResourceService;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestV1Controller
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteResourceService quoteResourceService;

    @GetMapping("/quote")
    public QuoteResource getQuoteResource() {
        return quoteResourceService.getQuoteResource();
    }
}
