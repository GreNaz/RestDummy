package com.LT.restDummy.helper;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.service.ResponseDelay;
import com.LT.restDummy.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DummyHelper {

    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static CompletableFuture<ResponseEntity<String>> returnResponse(String response,
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
            return ResponseDelay.scheduleResponse(DelayValue.getInstance().getDelayByService(serviceName),
                    response, serviceName);
        } else throw new ServiceException("Сервис временно недоступен. Включите заглушку");
    }

    public static void schedulingAvailability() {
        try {
            boolean isScheduledAvailability = false;
            LocalDateTime now = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
            HashMap<String, Boolean> servicesStop = new HashMap<>();

//            Проверка на соответствие текущего времени и времени остановки сервиса, если хоть один соответствует,
//            то он останавливается и время шедулится на 10минут
            for (Map.Entry<String, LocalDateTime> entry : AvailabilityServiceValue.getInstance().getSchedulers().entrySet()) {
                if (entry.getValue().isEqual(now)) {
                    servicesStop.put(entry.getKey(), true);
                    isScheduledAvailability = true;
                } else {
                    servicesStop.put(entry.getKey(), false);
                }
            }
            for (String service : servicesStop.keySet()) {
                if (servicesStop.get(service) == true) {
                    AvailabilityServiceValue.getInstance().setAvailabilityToService(service, false);
                }
            }
            if (isScheduledAvailability) {
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


    public static void schedulingDelay() {
        try {
            boolean isScheduledDelay = false;
            LocalDateTime now = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
            HashMap<String, Boolean> servicesDelay = new HashMap<>();

//            Проверка на соответствие текущего времени и времени остановки сервиса, если хоть один соответствует,
//            то он останавливается и время шедулится на 10минут
            for (Map.Entry<String, LocalDateTime> entry : DelayValue.getInstance().getSchedulers().entrySet()) {
                if (entry.getValue().isEqual(now)) {
                    servicesDelay.put(entry.getKey(), true);
                    isScheduledDelay = true;
                } else {
                    servicesDelay.put(entry.getKey(), false);
                }
            }
            for (String service : servicesDelay.keySet()) {
                if (servicesDelay.get(service) == true) {
                    DelayValue.getInstance().setNewDelayToService(service, DelayValue.getInstance().getSchedulerDelayByService(service));
                }
            }
            if (isScheduledDelay) {
                Thread.sleep(600000); // - 10 мин
                for (String service : servicesDelay.keySet()) {
                    if (servicesDelay.get(service) == true) {
                        DelayValue.getInstance().setNewDelayToService(service, DelayValue.getInstance().getServicesDefaultDelay().get(service));
                    }
                }
            } else {
                Thread.sleep(60000); // - 1 мин
            }
        } catch (InterruptedException ex) {

        }
    }
    public static String parameterCorrelate(String request, String param, String type) {
        request = request.toLowerCase(Locale.ROOT).replaceAll("\\s+", "");
        param = param.toLowerCase(Locale.ROOT);
        type = type.toLowerCase(Locale.ROOT);
        switch (type) {
            case "xml":
                return StringUtils.substringBetween(request, "<" + param + ">", "</" + param + ">");
            case "json":
                return StringUtils.substringBetween(request, "\"" + param + "\":\"", "\"");
            default:
                return "null";
        }
    }

   /* Отправляет пачки точек и чистит пачку, не уверена, что нужна чистка,
    но когда проверяла она сама не чистилась, не знаю механизм до конца, если включать, то нужно включить поток в главном классе
    @SneakyThrows
    public static void influxSender()  {
        InfluxWriter.getInstance().writeBatchPoints();
        InfluxWriter.getInstance().updateBatchPoints();
        Thread.sleep(30000); // - 30 сек
    }*/

}

