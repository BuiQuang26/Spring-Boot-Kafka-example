package com.example.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableKafka
public class KafkaExampleApplication {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

	@Bean
	 CommandLineRunner commandLineRunner(){

		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {

						kafkaTemplate.send("users", new Message( new Date(), "hi from java spring"));
					}
				};

				Timer timer = new Timer();
				timer.schedule(timerTask, 0, 5000);

			}
		};
	}
}
