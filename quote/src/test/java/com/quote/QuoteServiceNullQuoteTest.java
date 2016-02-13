package com.quote;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.quote.data.Quote;
import com.quote.data.Quotes;

@RunWith(MockitoJUnitRunner.class)
public class QuoteServiceNullQuoteTest {
	@Spy
	private Quotes quotes = getQuotes();

	@InjectMocks
	private QuoteService service;

	@Test
	public void testNull() {
		Quote quote = service.getRamdomQuote();
		assertNotNull(quote);
	}

	public Quotes getQuotes() {
		return null;
	}

}
