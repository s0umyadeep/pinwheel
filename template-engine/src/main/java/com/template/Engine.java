package com.template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Engine {

	private Parser parser = new Parser();
	private Map<String, Template> cache = new HashMap<>();


	public String transform(Properties model, String input) throws IOException, CircularReferenceException {
		return transform(model, input, null, false);
	}

	public String transform(Properties model, String input, String templateName, boolean refresh) throws IOException, CircularReferenceException {
		if (model == null || input == null) {
			throw new NullPointerException("inputs are empty");
		}
		Template template = getTemplate(templateName, input, refresh);
		String transformed = template.transform(model, new TemplateContext());
		return transformed;

	}

	private Template getTemplate(String templateName, String input, boolean refresh) {
		Template template = cache.get(templateName);
		if (template == null || refresh) {
			template = parser.parse(input);
			cache.put(templateName, template);
		}
		return template;
	}
}