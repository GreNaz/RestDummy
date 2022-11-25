package com.LT.restDummy.stub.helper;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.service.ResponseDelay;
import com.LT.restDummy.stub.exception.ServiceException;
//import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public class DummyHelper {
//    private static AvailabilityServiceValue availabilityServiceValue;
//    private static DelayValue delayValue;

//    @Autowired
//    public DummyHelper(AvailabilityServiceValue availabilityServiceValue, DelayValue delayValue){
//        this.availabilityServiceValue = availabilityServiceValue;
//        this.delayValue = delayValue;
//    }

//    public static DeferredResult<ResponseEntity<String>> returnResponse(String response,
//                                                                        String serviceName,
//                                                                        long delay,
//                                                                        Boolean isAvailable) {
//// Если параметры заданы, то обновляем их
//        if (delay != 0) {
//            delayValue.setNewDelayToService(serviceName, delay);
//        }
//        if (isAvailable != null) {
//            availabilityServiceValue.setAvailabilityToService(serviceName, isAvailable);
//        }
//// Если сервис доступен, то возвращаем его
//        if (AvailabilityServiceValue.getInstance().getAvailabilityByService(serviceName) == true) {
//            return ResponseDelay.scheduleResponse(DelayValue.getInstance().getDelayByService(serviceName),
//                    response);
//        } else throw new ServiceException("Сервис временно недоступен. Включите заглушку");
//    }

    public static CompletableFuture<ResponseEntity<String>> returnResponseComp(String response,
                                                                               String serviceName,
                                                                               long delay,
                                                                               Boolean isAvailable) {
        // Если параметры заданы, то обновляем их
        if (delay != 0) {
            DelayValue.getInstance().setNewDelayToService(serviceName, delay);
        }
        if (isAvailable != null) {
            AvailabilityServiceValue.getInstance().setAvailabilityToService(serviceName, isAvailable);
        }
        // Если сервис доступен, то возвращаем его
        if (AvailabilityServiceValue.getInstance().getAvailabilityByService(serviceName)) {
            return ResponseDelay.scheduleResponseComp(DelayValue.getInstance().getDelayByService(serviceName),
                    response);
        } else throw new ServiceException("Сервис временно недоступен. Включите заглушку");
    }
}

