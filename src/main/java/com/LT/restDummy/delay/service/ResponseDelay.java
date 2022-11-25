package com.LT.restDummy.delay.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*Класс отвечает за выставление задержки для rest сервиса*/
@Slf4j
public class ResponseDelay {

    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
//
//    public static DeferredResult<ResponseEntity<String>> scheduleResponse(long delay, String responseBody) {
//        DeferredResult<ResponseEntity<String>> response = new DeferredResult<>();
//        scheduler.schedule(() -> {
//            response.setResult(ResponseEntity.ok(responseBody));
//        }, delay, TimeUnit.MILLISECONDS);
//        return response;
//    }

    @SneakyThrows
    public static CompletableFuture<ResponseEntity<String>> scheduleResponseComp(long delay, String responseBody) {
//        CompletableFuture<ResponseEntity<String>> response = new CompletableFuture<>();
//        scheduler.schedule(() -> {
//            response.complete(ResponseEntity.ok(responseBody));
//        }, delay, TimeUnit.MILLISECONDS);
        Thread.sleep(delay);
        return CompletableFuture.completedFuture(ResponseEntity.ok(responseBody));
    }
}
