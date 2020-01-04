package com.borykapp.secure1.springsecurityjwt.domain.quote

import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Quote
import com.borykapp.secure1.springsecurityjwt.domain.quote.model.Value
import spock.lang.Specification

class QuoteResourceAssemblerSpec extends Specification {
    QuoteResourceAssembler quoteResourceAssembler = new QuoteResourceAssembler()

    def "should convert student to rest resource"() {
        given:
            def quote = new Quote("Type1", new Value(1, "Sample quote"))
        when:
            def result = quoteResourceAssembler.convert(quote)
        then:
            result.getQuote() == quote.getValue().getQuote()
            result.getQuoteId() == quote.getValue().getId()
            result.getType() == quote.getType()

    }
}
