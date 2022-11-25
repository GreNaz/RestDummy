package com.LT.restDummy.stub.controller;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.service.ResponseDelay;
import com.LT.restDummy.stub.helper.DummyHelper;
import com.LT.restDummy.stub.service.CustomerSurvey;
import com.LT.restDummy.stub.service.ExampleService;
import com.LT.restDummy.stub.service.ExampleService2;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;


@Slf4j
//@Controller
@RestController
public class RestDummyController {
//    private AvailabilityServiceValue availabilityServiceValue;

//    private HashMap<String, String> service_delay = new HashMap<String, String>() {
//        {
//            put("ExampleService", "1000");
//            put("ExampleService2", "10000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//        }
//    };
//
//    private HashMap<String, String> service_timeout = new HashMap<String, String>() {
//        {
//            put("ExampleService", "1000");
//            put("ExampleService2", "10000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//            put("ExampleService3", "7000");
//        }
//    };

//    public RestDummyController() {
//        DelayValue.getInstance().initialize(service_delay);
//
//    }

//    @Autowired
//    public RestDummyController(AvailabilityServiceValue availabilityServiceValue) {
//        this.availabilityServiceValue = availabilityServiceValue;
//
//    }

    @Async("fixedThreads")
    @PostMapping(value = "/customer_survey/v1/widgets/get", produces = "application/json")
    public CompletableFuture<ResponseEntity<String>> customerSurvey(@RequestBody JSONObject jsonObject,
                                                                 @RequestParam(defaultValue = "0") Long delay,
                                                                 @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponseComp(CustomerSurvey.getResponse(jsonObject), "CustomerSurvey", delay, isAvailable);
    }




    @Async("fixedThreads")
    @PostMapping(value = "/v2/ExampleService", produces = "application/json")
    public CompletableFuture<ResponseEntity<String>> exampleServiceV2(@RequestBody JSONObject jsonObject,
                                                                      @RequestParam(defaultValue = "0") Long delay,
                                                                      @RequestParam(required = false) Boolean isAvailable) {
        return DummyHelper.returnResponseComp(ExampleService.getResponse(jsonObject), "ExampleService", delay, isAvailable);
    }

//
//    @PostMapping(value = "/ExampleService2", produces = "application/json")
//    public DeferredResult<ResponseEntity<String>> exampleService2(@RequestBody JSONObject jsonObject) {
//
//        return ResponseDelay.scheduleResponse(DelayValue.getInstance().getDelayByService("ExampleService2"), ExampleService2.getResponse(jsonObject));
//    }


//    @PostMapping(value = "/ExampleService", produces = "application/json")
//    public DeferredResult<ResponseEntity<String>> exampleService(@RequestBody JSONObject jsonObject,
//                                                                 @RequestParam(defaultValue = "0") Long delay,
//                                                                 @RequestParam Boolean isAvailable) {
//
//        return DummyHelper.returnResponse(ExampleService.getResponse(jsonObject), "ExampleService", delay, isAvailable);
//    }

}
