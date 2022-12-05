package com.LT.restDummy.delay.model;

//import com.sun.istack.internal.NotNull;

//import com.sun.istack.internal.NotNull;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/*Класс отвечает за взаимодействие контроллера с задержками delay.properties*/

@Slf4j
public class DelayValue {
//    Для возвращения дефолтных задержек, неизменяемое поле
    private static final ConcurrentHashMap<String, Long> servicesDefaultDelay = new ConcurrentHashMap<>();
//    текущая задержка
    private static final ConcurrentHashMap<String, Long> currentDelay = new ConcurrentHashMap<>();
//    таймауты сервисов
    private static final ConcurrentHashMap<String, Long> servicesTimeout = new ConcurrentHashMap<>();
//    время в которое будет выставлена новая задержка
    private static final ConcurrentHashMap<String, LocalDateTime> servicesScheduler = new ConcurrentHashMap<>();
//    задержка, которая будет выставлена во время работы шедулера
    private static final ConcurrentHashMap<String, Long> schedulerDelays = new ConcurrentHashMap<>();


    public static class DelayValueHolder {
        static final DelayValue HOLDER_INSTANCE = new DelayValue();
    }

    public static DelayValue getInstance() {
        return DelayValueHolder.HOLDER_INSTANCE;
    }

    public DelayValue initialize(HashMap<String, Long> delays, HashMap<String, Long> timeouts, HashMap<String, LocalDateTime> schedulers) {
//        инициализация задержек сервисов и шедулера
        for (Map.Entry<String, Long> entry : delays.entrySet()) {
            currentDelay.put(entry.getKey().toLowerCase(), entry.getValue());
            servicesDefaultDelay.put(entry.getKey().toLowerCase(), entry.getValue());
        }
//                инициализация таймаутов сервисов
        for (Map.Entry<String, Long> timeout : timeouts.entrySet()) {
            servicesTimeout.put(timeout.getKey().toLowerCase(), timeout.getValue());
        }
        ConcurrentHashMap<String, Long> calc10Delay =  calculateMinus10PercentDelay();
        for (Map.Entry<String, Long> entry : delays.entrySet()){
            servicesScheduler.put(entry.getKey().toLowerCase(Locale.ROOT),
                    schedulers.getOrDefault(
                            entry.getKey().toLowerCase(Locale.ROOT),
                            LocalDateTime.of(2000, 01, 01, 01, 01)));
            schedulerDelays.put(entry.getKey().toLowerCase(Locale.ROOT), calc10Delay.get(entry.getKey().toLowerCase(Locale.ROOT)));
        }


        return this;
    }

    public DelayValue initialize(ConcurrentHashMap<String, Long> delays) {
        for (Map.Entry<String, Long> delay : delays.entrySet()) {
            currentDelay.put(delay.getKey().toLowerCase(), delay.getValue());
            servicesDefaultDelay.put(delay.getKey().toLowerCase(), delay.getValue());
        }
        return this;
    }

    public DelayValue initializeWithoutDefault(ConcurrentHashMap<String, Long> delays) {
        for (Map.Entry<String, Long> delay : delays.entrySet()) {
            currentDelay.put(delay.getKey().toLowerCase(), delay.getValue());
        }
        return this;
    }


    public long getDelayByService(@NonNull String nameOfService) {
        return currentDelay.getOrDefault(nameOfService.toLowerCase(), 1000L);
    }

    public long getTimeoutByService(@NonNull String nameOfService) {
        return servicesTimeout.getOrDefault(nameOfService.toLowerCase(), 0L);
    }

    public List<String> getServices() {
        return Collections.list(currentDelay.keys());
    }

    public ConcurrentHashMap<String, Long> getServicesDefaultDelay() {
        return servicesDefaultDelay;
    }

    public void setNewDelayToService(@NonNull String nameOfService, @NonNull long valueOfDelay) {
        final String key = nameOfService.toLowerCase();
        if (currentDelay.containsKey(key)) {
            //TODO надо ли удалять?
            currentDelay.remove(key);
            currentDelay.put(key, valueOfDelay);
        } else
            log.error("Cant set new value for '{}', service not found", nameOfService);
    }

    public LocalDateTime getSchedulerByService(@NonNull String nameOfService) {
        return servicesScheduler.getOrDefault(nameOfService.toLowerCase(), LocalDateTime.of(2000, 01, 01, 01, 01));
    }

    public ConcurrentHashMap<String, LocalDateTime> getSchedulers() {
        return servicesScheduler;
    }

//    возвращать задержку для шедуллера

    public long getSchedulerDelayByService(@NonNull String nameOfService) {
        return schedulerDelays.getOrDefault(nameOfService.toLowerCase(), 1000L);
    }


//    выставлять задержку для шедуллера
public void setNewDelayToScheduler(@NonNull String nameOfService, @NonNull long valueOfDelay) {
    final String key = nameOfService.toLowerCase();
    if (schedulerDelays.containsKey(key)) {
        //TODO надо ли удалять?
        schedulerDelays.remove(key);
        schedulerDelays.put(key, valueOfDelay);
    } else
        log.error("Cant set new value for '{}', service not found", nameOfService);
}

    public void setSchedulerToService(@NonNull String nameOfService, @NonNull LocalDateTime scheduler) {
        final String key = nameOfService.toLowerCase();
        if (servicesScheduler.containsKey(key)) {
            //TODO надо ли удалять?
            servicesScheduler.remove(key);
            servicesScheduler.put(key, scheduler);
        } else
            log.error("Cant set new value for '{}', service not found", nameOfService);
    }

    //    ставит задержку -10% от таймаута. Если таймаут не задан, то оставляет задержку как есть.
    private ConcurrentHashMap<String, Long> calculateMinus10PercentDelay() {
        ConcurrentHashMap<String, Long> calculatedDelay = new ConcurrentHashMap<>();
        for (String service : getServices()) {
            if (servicesTimeout.containsKey(service)) {
                Double newDelay = servicesTimeout.get(service) * 0.9;
                calculatedDelay.put(service, newDelay.longValue());
            } else {
                calculatedDelay.put(service, currentDelay.get(service));
            }
        }
        return calculatedDelay;
    }

    public DelayValue setMinus10PercentDelay(){
        return initializeWithoutDefault(calculateMinus10PercentDelay());
    }

}
