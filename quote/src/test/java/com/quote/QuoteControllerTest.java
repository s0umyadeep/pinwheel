package com.quote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuoteControllerTest {

	@Mock
	private QuoteService quoteService;

	@InjectMocks
	private QuoteController quoteController;

	@Test
	public void testQuote() {
		quoteController.quote();
		Mockito.verify(quoteService, Mockito.times(1)).getRamdomQuote();
	}
}
