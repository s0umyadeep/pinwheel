package com.utility;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showValue(String us, String them, Model model) {
		DataRes d = new DataRes();
		d.setCode("15627");
		model.addAttribute("item", d);
		return "hello";
	}
}
