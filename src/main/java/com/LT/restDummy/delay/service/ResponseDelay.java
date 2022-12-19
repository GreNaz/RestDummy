package com.LT.restDummy.delay.service;

import com.LT.restDummy.influx.InfluxWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*Класс отвечает за выставление задержки для rest сервиса*/
@Slf4j
public class ResponseDelay {

    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    @SneakyThrows
    public static CompletableFuture<ResponseEntity<String>> scheduleResponse(long delay, String responseBody, String operationName) {
        CompletableFuture<ResponseEntity<String>> response = new CompletableFuture<>();
        scheduler.schedule(() -> {
            response.complete(ResponseEntity.ok(responseBody));
            log.info("RESPONSE: " + responseBody);
            InfluxWriter.getInstance().addPoint(operationName);
        }, delay, TimeUnit.MILLISECONDS);
        return response;
    }
}
