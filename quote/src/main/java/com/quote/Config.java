package com.quote;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quote.data.Quotes;

@Configuration
public class Config {

	@Bean
	public Quotes quotes() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try (InputStream in = Config.class.getClassLoader().getResourceAsStream("quotes.json")) {
			Quotes quotes = mapper.readValue(in, Quotes.class);
			return quotes;
		}
	}
}
