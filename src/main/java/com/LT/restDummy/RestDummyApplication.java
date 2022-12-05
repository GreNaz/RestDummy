package com.LT.restDummy;

import com.LT.restDummy.helper.DummyHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RestDummyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDummyApplication.class, args);
        Thread  scheduleAvailability = new Thread(() -> {
            while (true) {
                DummyHelper.schedulingAvailability();
            }
        });
        scheduleAvailability.start(); // заводим


        Thread  scheduleDelay = new Thread(() -> {
            while (true) {
                DummyHelper.schedulingDelay();
            }
        });
        scheduleDelay.start(); // заводим


        /*для отправки пачек точек в инфлюкс раз в 30 сек
        Thread  influxSender = new Thread(() -> {
            while (true) {
                DummyHelper.influxSender();
            }
        });
        influxSender.start();*/
    }



}
