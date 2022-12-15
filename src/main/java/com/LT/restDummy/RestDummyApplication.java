package com.LT.restDummy;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.util.Properties;


@Slf4j
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class RestDummyApplication {

    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileInputStream("properties"));
        System.setProperty("server.port", properties.getProperty("server.port"));
        SpringApplication.run(RestDummyApplication.class, args);
    }
}
