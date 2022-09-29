package com.example.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableKafka
public class KafkaExampleApplication {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

	@Bean
	 CommandLineRunner commandLineRunner(){

		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				kafkaTemplate.send("users", "hi from java spring");
			}
		};
	}
}
