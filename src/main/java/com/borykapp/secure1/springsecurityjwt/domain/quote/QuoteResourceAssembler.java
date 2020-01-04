package com.borykapp.secure1.springsecurityjwt.domain.quote;

import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuoteResourceAssembler implements Converter<Quote, QuoteResource> {
    @Override
    public QuoteResource convert(Quote source) {
        return new QuoteResource(source.getValue().getQuote(), source.getValue().getId(), source.getType());
    }
}
