package com.utility.elasticsearch;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Picker extends QuestionProcessor {
	@Override
	public void run(String... args) throws Exception {
		List<String> numbersToPick = selectRandomly();
		int lineNumber = 1;
		for (Question question : fetchQuestions(numbersToPick)) {
			if (question != null) {
				System.out.println(lineNumber++ + ". " + question.getQuestionText() + " (" + question.getId() + ")");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Picker.class, "--debug").close();
	}

}
