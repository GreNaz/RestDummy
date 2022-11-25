package com.LT.restDummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableAsync
@SpringBootApplication
public class RestDummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDummyApplication.class, args);
	}

	@Bean
	public ExecutorService fixedThreads(){
//		чтобы обрабатывало 100тпс одновременно, вероятно, нужно 100 потоков
		return Executors.newFixedThreadPool(10);

//		потоки не фиксированы
//		return Executors.newCachedThreadPool();
	}


}
