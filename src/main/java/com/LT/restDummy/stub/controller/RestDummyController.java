package com.LT.restDummy.stub.controller;

import com.LT.restDummy.helper.DummyHelper;
import com.LT.restDummy.stub.service.CustomerSurvey;
import com.LT.restDummy.stub.service.ExampleService;
import com.LT.restDummy.stub.service.GetCreditCardAnnuity;
import com.LT.restDummy.stub.service.GetCreditCardInfoAsync;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@Slf4j
@RestController()
public class RestDummyController {

    public final InfluxDB influxDB;

    public RestDummyController(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

//host:port/service?
    @PostMapping(value = "/GetCreditCardAnnuity")
    public CompletableFuture<ResponseEntity<String>> GetCreditCardAnnuity(@RequestBody String request,
                                                                          @RequestParam(defaultValue = "0") Long delay,
                                                                          @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponse(GetCreditCardAnnuity.getResponse(request, "json"), "GetCreditCardAnnuity", delay, isAvailable);
    }

    @PostMapping(value = "/GetCreditCardInfoAsync")
    public CompletableFuture<ResponseEntity<String>> GetCreditCardInfoAsync(@RequestBody String request,
                                                                            @RequestParam(defaultValue = "0") Long delay,
                                                                            @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponse(GetCreditCardInfoAsync.getResponse(request, "xml"), "GetCreditCardInfoAsync", delay, isAvailable);
    }


    @PostMapping(value = "/customer_survey/v1/widgets/get", produces = "application/json")
    public CompletableFuture<ResponseEntity<String>> customerSurvey(@RequestBody JSONObject jsonObject,
                                                                    @RequestParam(defaultValue = "0") Long delay,
                                                                    @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponse(CustomerSurvey.getResponse(jsonObject), "CustomerSurvey", delay, isAvailable);
    }

    @PostMapping(value = "/v2/ExampleService", produces = "application/json")
    public CompletableFuture<ResponseEntity<String>> exampleServiceV2(@RequestBody JSONObject jsonObject,
                                                                      @RequestParam(defaultValue = "0") Long delay,
                                                                      @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponse(ExampleService.getResponse(jsonObject), "ExampleService", delay, isAvailable);
    }
}
