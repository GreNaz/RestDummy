package com.LT.restDummy.controller;

import com.LT.restDummy.helper.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

/*Класс реализует ответ на rest вызов сервисов*/
@Slf4j
@RestController
public class RestDummyController {

    public final InfluxDB influxDB;

    public RestDummyController(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }


    @PostMapping("/services")
    public CompletableFuture<ResponseEntity<String>> getResponse(@RequestBody String request,
                                                                 @RequestParam String service,
                                                                 @RequestParam(defaultValue = "0") Long delay,
                                                                 @RequestParam(required = false) Boolean isAvailable) {
        return ResponseHelper.returnResponse(request, service, delay, isAvailable);
    }

    @PostMapping("/customEndpoint/**")
    public CompletableFuture<ResponseEntity<String>> getResponseCustomEndpoint(@RequestBody String request,
                                                                               @RequestParam(defaultValue = "0") Long delay,
                                                                               @RequestParam(required = false) Boolean isAvailable,
                                                                               HttpServletRequest httpServletRequest) {
        String path = httpServletRequest.getRequestURI().replaceAll("/customEndpoint", "");
        return ResponseHelper.returnResponse(request, path, delay, isAvailable);
    }
}
