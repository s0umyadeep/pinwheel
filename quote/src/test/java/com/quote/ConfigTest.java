package com.quote;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.quote.data.Quotes;

public class ConfigTest {

	@Test
	public void testConfig() throws IOException {
		Config config = new Config();
		Quotes quotes = config.quotes();
		assertNotNull(quotes);
		assertNotNull(quotes.getQuotes());
		assertFalse(quotes.getQuotes().isEmpty());
	}
}
