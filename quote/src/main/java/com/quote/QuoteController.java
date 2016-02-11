package com.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("/quote")
	public Quote quote(){
		return quoteService.getRamdomQuote();
	}

}
