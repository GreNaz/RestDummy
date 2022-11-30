package com.LT.restDummy.stub.controller;

import com.LT.restDummy.stub.helper.DummyHelper;
import com.LT.restDummy.stub.service.CustomerSurvey;
import com.LT.restDummy.stub.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/scheduler")
//    public String scheduler() {
//        DummyHelper.scheduler();
//        return "success";
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
