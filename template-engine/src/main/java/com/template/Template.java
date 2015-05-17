package com.template;

import java.util.Properties;

public interface Template {

	public String transform(Properties model, TemplateContext context) throws CircularReferenceException;
	
	
}
