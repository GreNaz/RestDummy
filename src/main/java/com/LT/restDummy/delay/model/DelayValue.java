package com.LT.restDummy.delay.model;

//import com.sun.istack.internal.NotNull;

//import com.sun.istack.internal.NotNull;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*Класс отвечает за взаимодействие контроллера с задержками delay.properties*/

@Slf4j
public class DelayValue {
    private static final ConcurrentHashMap<String, Long> servicesWithDelay = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> servicesTimeout = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> servicesDefaultDelay = new ConcurrentHashMap<>();

    public static class DelayValueHolder {
        static final DelayValue HOLDER_INSTANCE = new DelayValue();
    }

    public static DelayValue getInstance() {
        return DelayValueHolder.HOLDER_INSTANCE;
    }

    public DelayValue initialize(HashMap<String, Long> delays, HashMap<String, Long> timeouts) {
        for (Map.Entry<String, Long> delay : delays.entrySet()) {
            servicesWithDelay.put(delay.getKey().toLowerCase(), delay.getValue());
            servicesDefaultDelay.put(delay.getKey().toLowerCase(), delay.getValue());
        }
        for (Map.Entry<String, Long> timeout : timeouts.entrySet()) {
            servicesTimeout.put(timeout.getKey().toLowerCase(), timeout.getValue());
        }
        return this;
    }


    public DelayValue initialize(ConcurrentHashMap<String, Long> delays) {
        for (Map.Entry<String, Long> delay : delays.entrySet()) {
            servicesWithDelay.put(delay.getKey().toLowerCase(), delay.getValue());
            servicesDefaultDelay.put(delay.getKey().toLowerCase(), delay.getValue());
        }
        return this;
    }

    public DelayValue initializeWithoutDefault(ConcurrentHashMap<String, Long> delays) {
        for (Map.Entry<String, Long> delay : delays.entrySet()) {
            servicesWithDelay.put(delay.getKey().toLowerCase(), delay.getValue());
        }
        return this;
    }

    public long getDelayByService(@NonNull String nameOfService) {
        return servicesWithDelay.getOrDefault(nameOfService.toLowerCase(), 1000L);
    }

    public long getTimeoutByService(@NonNull String nameOfService) {
        return servicesTimeout.getOrDefault(nameOfService.toLowerCase(), 0L);
    }

    public List<String> getServices() {
        return Collections.list(servicesWithDelay.keys());
    }

//    ставит задержку -10% от таймаута. Если таймаут не задан то оставляет задержку как есть.
    public DelayValue calculate10Delay() {
        ConcurrentHashMap<String, Long> calculatedDelay = new ConcurrentHashMap<>();
        for (String service : getServices()) {
            if (servicesTimeout.containsKey(service)) {
                Double newDelay = servicesTimeout.get(service) * 0.9;
                calculatedDelay.put(service, newDelay.longValue());
            } else {
                calculatedDelay.put(service, servicesWithDelay.get(service));
            }
        }
        return initializeWithoutDefault(calculatedDelay);
    }

    public ConcurrentHashMap<String, Long> getServicesDefaultDelay() {
        return servicesDefaultDelay;
    }


    public void setNewDelayToService(@NonNull String nameOfService, @NonNull long valueOfDelay) {
        final String key = nameOfService.toLowerCase();
        if (servicesWithDelay.containsKey(key)) {
            //TODO надо ли удалять?
            servicesWithDelay.remove(key);
            servicesWithDelay.put(key, valueOfDelay);
        } else
            log.error("Cant set new value for '{}', service not found", nameOfService);
    }
}
