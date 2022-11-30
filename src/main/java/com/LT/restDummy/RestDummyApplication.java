package com.LT.restDummy;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.stub.helper.DummyHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableAsync
@SpringBootApplication
public class RestDummyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDummyApplication.class, args);
        Thread run = new Thread(() -> {
            while (true) {
                DummyHelper.scheduling();
            }
        });
        run.start(); // заводим
    }

    @Bean
    public ExecutorService fixedThreads() {
//		чтобы обрабатывало 100тпс одновременно, вероятно, нужно 100 потоков
        return Executors.newFixedThreadPool(10);
//		потоки не фиксированы
//		return Executors.newCachedThreadPool();
    }


}
