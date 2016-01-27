package com.utility.elasticsearch;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;

import com.google.common.base.Charsets;
import com.google.common.io.Files;


public abstract class QuestionProcessor implements CommandLineRunner {
	@Autowired
	private QuestionRepository repository;

	@Bean
	public TransportClientFactoryBean transportClientFactoryBean() {
		TransportClientFactoryBean transportClientFactoryBean = new TransportClientFactoryBean();
		transportClientFactoryBean.setClientTransportSniff(false);
		transportClientFactoryBean.setClusterName("my-application");
		transportClientFactoryBean.setClusterNodes("127.0.0.1:9300");
		return transportClientFactoryBean;
	}


	protected List<Question> fetchQuestions(List<String> numbersToPick) {
		List<Question> questions = new LinkedList<>();
		if (numbersToPick != null) {
			numbersToPick.forEach(number -> {
				questions.add(repository.findOne(number));
			});
		}
		return questions;
	}

	protected void saveQuestions() throws IOException {
		List<String> lines = Files.readLines(new File("/Users/soum/Documents/evernotes-export/out-m1.txt"),
				Charsets.UTF_8);
		if (lines != null) {
			int id = 1;
			for (String line : lines) {
				Question question = new Question();
				question.setId(String.valueOf(id));
				question.setQuestionText(line);
				repository.save(question);
				id += 1;
			}
		}
	}

	protected List<String> selectRandomly() {
		List<String> numbersToPick = new LinkedList<>();
		Set<Integer> duplicateRemover = new HashSet<>();
		Random r = new Random();
		int howmanyQuestions = 50;
		int retry = 0;
		for (int i = 0; i < howmanyQuestions; i++) {
			int low = 1;
			int high = 649;
			int result = r.nextInt(high - low) + low;
			if (duplicateRemover.contains(result)) {
				i -= 1;
				retry += 1;
				continue;
			}
			duplicateRemover.add(result);
			System.out.println((i + 1) + ". " + result);
			numbersToPick.add(String.valueOf(result));
		}
		System.out.println("# of retry is " + retry);
		return numbersToPick;
	}

}
