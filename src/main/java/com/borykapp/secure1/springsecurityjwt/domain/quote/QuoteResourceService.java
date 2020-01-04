package com.borykapp.secure1.springsecurityjwt.domain.quote;

import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteResourceService {
    private final QuoteService quoteService;
    private final QuoteResourceAssembler quoteResourceAssembler;

    public QuoteResource getQuoteResource() {
        Quote quote = quoteService.getQuote();
        return quoteResourceAssembler.convert(quote);
    }
}
