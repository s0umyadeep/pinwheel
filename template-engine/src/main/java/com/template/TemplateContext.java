package com.template;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TemplateContext {

	private Map<String, String> context = new HashMap<>();
	private Parser parser = new Parser();

	public String findValue(String expr) throws CircularReferenceException {
		return findValue(expr, null);
	}

	public String findValue(String expr, Set<String> visited) throws CircularReferenceException {
		if (expr == null || expr.isEmpty()) {
			return null;
		}
		if (visited == null) {
			visited = new HashSet<>();
		} else if (visited.contains(expr)) {
			throw new CircularReferenceException(expr + " is referring to itself");
		}

		Stack<String> stack = new Stack<>();
		String key = evaluateExpr(expr, stack);

		String value = context.get(key);
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		Set<String> macros = parser.getMacros(value);
		if (macros.isEmpty()) {
			return value;
		}
		for (String macro : macros) {
			visited.add(expr);
			String evalued = findValue(macro, visited);
			if (evalued != null && !evalued.trim().isEmpty()) {
				context.put(key, context.get(key).replaceAll("\\" + macro, evalued));
			}
		}

		String processed = context.get(key);
		processed = checkforMoreThanOneDollar(processed, stack);
		return processed;
	}

	private String checkforMoreThanOneDollar(String value, Stack<String> stack) throws CircularReferenceException {
		while (!stack.isEmpty()) {
			value = stack.pop() + value;
		}
		if (value.startsWith(Parser.START_WITH)) {
			Set<String> macros = parser.getMacros(value);
			for (String macro : macros) {
				String macroValue = findValue(macro);
				if (macroValue != null && !macroValue.trim().isEmpty()) {
					value = value.replaceAll("\\" + macro, macroValue);
				}
			}
		}
		return value;
	}

	public String evaluateExpr(String expr, Stack<String> stack) {
		String key = expr.replaceFirst("\\" + Parser.START_WITH, "");
		if (key.startsWith(Parser.START_WITH)) {
			stack.push(Parser.START_WITH);
			key = evaluateExpr(key, stack);
		}
		return key;
	}

	public void set(String key, String value) {
		context.put(key, value);
	}
}
