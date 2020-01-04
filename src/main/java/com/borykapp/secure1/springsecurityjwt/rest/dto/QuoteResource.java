package com.borykapp.secure1.springsecurityjwt.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class QuoteResource {
    private String quote;
    private Integer quoteId;
    private String type;
}
