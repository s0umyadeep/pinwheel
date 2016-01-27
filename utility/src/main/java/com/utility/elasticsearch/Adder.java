package com.utility.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Adder extends QuestionProcessor {
	@Override
	public void run(String... args) throws Exception {
		saveQuestions();

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Adder.class, "--debug").close();
	}
}