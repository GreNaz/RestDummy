package com.LT.restDummy.stub.helper;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.service.ResponseDelay;
import com.LT.restDummy.stub.exception.ServiceException;
//import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class DummyHelper {

    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

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

    public static void scheduling() {
        try {
            boolean isScheduled = false;
            LocalDateTime now = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
            HashMap<String, Boolean> servicesStop = new HashMap<>();

//            Проверка на соответствие текущего времени и времени остановки сервиса, если хоть один соответствует,
//            то он останавливается и время шедулится на 10минут
            for (Map.Entry<String, LocalDateTime> entry : AvailabilityServiceValue.getInstance().getSchedulers().entrySet()) {
                    if (entry.getValue().isEqual(now) ) {
                    servicesStop.put(entry.getKey(), true);
                    isScheduled = true;
                } else {
                    servicesStop.put(entry.getKey(), false);
                }
            }
            for (String service : servicesStop.keySet()) {
                if (servicesStop.get(service) == true) {
                    AvailabilityServiceValue.getInstance().setAvailabilityToService(service, false);
                }
            }
            if (isScheduled) {
                Thread.sleep(600000); // - 10 мин
                for (String service : servicesStop.keySet()) {
                    if (servicesStop.get(service) == true) {
                        AvailabilityServiceValue.getInstance().setAvailabilityToService(service, true);
                    }
                }
            } else {
                Thread.sleep(60000); // - 1 мин
            }
        } catch (InterruptedException ex) {
        }
    }
}

