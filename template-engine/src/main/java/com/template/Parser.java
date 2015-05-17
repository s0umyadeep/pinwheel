package com.template;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Parser {

	public static final String START_WITH="$";
	public static final String END_WITH=" \t\n\r\f,.:;?![]'";
	
	
	public Template parse(String input) {
		Set<String> macros = getMacros(input);
		Template t = new TemplateImpl(macros, input);
		return t;
	}


	protected Set<String> getMacros(String input) {
		Set<String> macros = new HashSet<>();
		StringTokenizer tokenizer = new StringTokenizer(input, END_WITH);
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if (word.startsWith(START_WITH)) {
				macros.add(word);
			}
		}
		return macros;
	}

}