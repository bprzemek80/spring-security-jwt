package com.borykapp.secure1.springsecurityjwt.base;

import com.borykapp.secure1.springsecurityjwt.domain.quote.QuoteResourceService;
import com.borykapp.secure1.springsecurityjwt.rest.QuoteController;
import com.borykapp.secure1.springsecurityjwt.rest.dto.QuoteResource;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public abstract class QuoteBase {
    @InjectMocks
    QuoteController quoteController;

    @Mock
    QuoteResourceService quoteResourceService;

    @Before
    public void setup() {
        stubForGetQuote();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(quoteController).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    private void stubForGetQuote() {
        when(quoteResourceService.getQuoteResource())
                .thenReturn(new QuoteResource("Sample quote", 1, "Type1"));
    }
}
