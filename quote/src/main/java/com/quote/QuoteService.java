package com.quote;

import org.springframework.stereotype.Component;

@Component
public class QuoteService {

	public Quote getRamdomQuote() {
		Quote quote = new Quote();
		quote.setAuthor("Al Gore");
		quote.setTopic("Politics");
		quote.setQuoteText("I invented the internet.");
		return quote;
	}

}
