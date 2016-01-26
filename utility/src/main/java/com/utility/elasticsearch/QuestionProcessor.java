package com.utility.elasticsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootApplication
public class QuestionProcessor implements CommandLineRunner {
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

	@Override
	public void run(String... args) throws Exception {
		// this.repository.deleteAll();
		if (args != null) {
			if (Stream.of(args).anyMatch(arg -> {
				return StringUtils.equalsIgnoreCase(arg, "add");
			})) {
				saveQuestions();
			} else {
				List<String> numbersToPick = selectRandomly();
				fetchQuestions(numbersToPick);
			}
		}
	}

	private List<Question> fetchQuestions(List<String> numbersToPick) {
		List<Question> questions = new LinkedList<>();
		if (numbersToPick != null) {
			numbersToPick.forEach(number -> {
				questions.add(repository.findOne(number));
			});
		}
		return questions;
	}

	private void saveQuestions() {
		// TODO Auto-generated method stub

	}

	private List<String> selectRandomly() {
		List<String> numbersToPick = new LinkedList<>();
		numbersToPick.add("1");
		return numbersToPick;
	}

	// private void saveCustomers() {
	// this.repository.save(new Customer("Alice", "Smith"));
	// this.repository.save(new Customer("Bob", "Smith"));
	// }

	// private void fetchAllCustomers() {
	// System.out.println("Customers found with findAll():");
	// System.out.println("-------------------------------");
	// for (Customer customer : this.repository.findAll()) {
	// System.out.println(customer);
	// }
	// System.out.println();
	// }
	//
	// private void fetchIndividualCustomers() {
	// System.out.println("Customer found with findByFirstName('Alice'):");
	// System.out.println("--------------------------------");
	// System.out.println(this.repository.findByFirstName("Alice"));
	//
	// System.out.println("Customers found with findByLastName('Smith'):");
	// System.out.println("--------------------------------");
	// for (Customer customer : this.repository.findByLastName("Smith")) {
	// System.out.println(customer);
	// }
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(QuestionProcessor.class, "--debug").close();
	}
}
