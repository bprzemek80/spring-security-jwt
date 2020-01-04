package com.borykapp.secure1.springsecurityjwt.domain.quote;

import com.borykapp.secure1.springsecurityjwt.domain.quote.exception.QuoteNotFoundException;
import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final RestTemplate restTemplate;

    public Quote getQuote() {
        return ofNullable(restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class))
                .orElseThrow(createQuoteNotFoundException());
    }

    private static Supplier<QuoteNotFoundException> createQuoteNotFoundException() {
        return () -> new QuoteNotFoundException("Can't find quote!");
    }
}
