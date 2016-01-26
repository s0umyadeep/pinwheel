package com.utility.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QuestionRepository extends ElasticsearchRepository<Question, String> {
	public Question findByQuestionText(String questionText);
}
