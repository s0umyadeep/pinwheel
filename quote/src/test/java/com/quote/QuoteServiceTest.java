package com.quote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.quote.data.Quote;
import com.quote.data.Quotes;

@RunWith(MockitoJUnitRunner.class)
public class QuoteServiceTest {

	@Spy
	private Quotes quotes = getQuotes();
	
	@InjectMocks
	private QuoteService service;

	@Test
	public void testGetRandomQuote() {
		Quote quote = service.getRamdomQuote();
		assertNotNull(quote);
		assertEquals("Hello", quote.getQuoteText());
	}

	public Quotes getQuotes() {
		Quotes quotes = new Quotes();
		quotes.setId("1");

		Quote quote = new Quote();
		quote.setAuthor("Al");
		quote.setQuoteText("Hello");
		quote.setTopic("politics");

		List<Quote> qts = new ArrayList<>();
		qts.add(quote);
		quotes.setQuotes(qts);
		return quotes;
	}
}
