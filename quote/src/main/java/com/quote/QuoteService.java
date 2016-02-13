package com.quote;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quote.data.Quote;
import com.quote.data.Quotes;

@Component
public class QuoteService {

	@Autowired
	private Quotes quotes;

	public Quote getRamdomQuote() {
		return selectAtRandom();
	}

	private Quote selectAtRandom() {
		if (quotes != null && quotes.getQuotes() != null && !quotes.getQuotes().isEmpty()) {
			Collections.shuffle(quotes.getQuotes());
			for (Quote quote : quotes.getQuotes()) {
				return quote;
			}
		}
		return defaultQuote();
	}

	private Quote defaultQuote() {
		Quote quote = new Quote();
		quote.setAuthor("Al Gore");
		quote.setTopic("Politics");
		quote.setQuoteText("I invented the internet.");
		return quote;
	}

}
