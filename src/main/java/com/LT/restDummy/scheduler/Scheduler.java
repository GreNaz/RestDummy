package com.LT.restDummy.scheduler;

import com.LT.restDummy.availability.model.AvailabilityValue;
import com.LT.restDummy.delay.model.DelayValue;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/*Класс каждые 60с делает проверку текущего времени и времени задержки,
если оно совпадает - выставляется задержка или выключается сервис*/
@Component
public class Scheduler {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @SneakyThrows
    @Scheduled(fixedRate = 60000)
    public static void schedulingAvailability() {
        boolean isScheduledAvailability = false;
        LocalDateTime now = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
        HashMap<String, Boolean> servicesStop = new HashMap<>();

/*            Проверка на соответствие текущего времени и времени остановки сервиса, если хоть один соответствует,
            то он останавливается и время шедулится на 10минут*/
        for (Map.Entry<String, LocalDateTime> entry : AvailabilityValue.getInstance().getSchedulers().entrySet()) {
            if (entry.getValue().isEqual(now)) {
                servicesStop.put(entry.getKey(), true);
                isScheduledAvailability = true;
            } else {
                servicesStop.put(entry.getKey(), false);
            }
        }
        for (String service : servicesStop.keySet()) {
            if (servicesStop.get(service)) {
                AvailabilityValue.getInstance().setAvailabilityToService(service, false);
            }
        }
        if (isScheduledAvailability) {
            Thread.sleep(60000); // - 10 ???
            for (String service : servicesStop.keySet()) {
                if (servicesStop.get(service)) {
                    AvailabilityValue.getInstance().setAvailabilityToService(service, true);
                }
            }
        }
    }

    @SneakyThrows
    @Scheduled(fixedRate = 60000)
    public static void schedulingDelay() {
        boolean isScheduledDelay = false;
        LocalDateTime now = LocalDateTime.parse(LocalDateTime.now().format(DATE_TIME_FORMATTER), DATE_TIME_FORMATTER);
        HashMap<String, Boolean> servicesDelay = new HashMap<>();

/*            Проверка на соответствие текущего времени и времени остановки сервиса, если хоть один соответствует,
            то он останавливается и время шедулится на 10минут*/
        for (Map.Entry<String, LocalDateTime> entry : DelayValue.getInstance().getSchedulers().entrySet()) {
            if (entry.getValue().isEqual(now)) {
                servicesDelay.put(entry.getKey(), true);
                isScheduledDelay = true;
            } else {
                servicesDelay.put(entry.getKey(), false);
            }
        }
        for (String service : servicesDelay.keySet()) {
            if (servicesDelay.get(service)) {
                DelayValue.getInstance().setNewDelayToService(service, DelayValue.getInstance().getSchedulerDelayByService(service));
            }
        }
        if (isScheduledDelay) {
            Thread.sleep(60000); // - 10 мин
            for (String service : servicesDelay.keySet()) {
                if (servicesDelay.get(service)) {
                    DelayValue.getInstance().setNewDelayToService(service, DelayValue.getInstance().getServicesDefaultDelay().get(service));
                }
            }
        }

    }

}

