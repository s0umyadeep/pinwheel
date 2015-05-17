package com.template;

import java.util.Properties;
import java.util.Set;
import java.util.Stack;

public class TemplateImpl implements Template {

	private Set<String> macros;
	private String input;

	public TemplateImpl(Set<String> macros, String input) {
		this.macros = macros;
		this.input = input;
	}

	@Override
	public String transform(Properties model, TemplateContext context) throws CircularReferenceException {
		String toReturn = new String(input);
		for (Object key : model.keySet()) {
			String stringKey = (String) key;
			context.set(stringKey, model.getProperty(stringKey));
		}

		for (String macro : macros) {
			String value = context.findValue(macro);
			if (value != null && !value.trim().isEmpty()) {
				String regex = escape(macro, context);
				value = escape(value, context);
				toReturn = toReturn.replaceAll(regex, value);
			}
		}

		return toReturn;
	}

	private String escape(String macro, TemplateContext context) {
		if (macro.startsWith(Parser.START_WITH)) {
			Stack<String> stack = new Stack<>();
			String s = context.evaluateExpr(macro, stack);
			while (!stack.isEmpty()) {
				stack.pop();
				s = "\\" + Parser.START_WITH + s;
			}

			return "\\" + Parser.START_WITH + s;
		}
		return macro;
	}
}