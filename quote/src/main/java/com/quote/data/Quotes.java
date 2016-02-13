package com.quote.data;

import java.util.List;

public class Quotes {

	private String id;
	private List<Quote> quotes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Quote> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
}