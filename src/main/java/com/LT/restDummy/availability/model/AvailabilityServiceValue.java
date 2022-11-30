package com.LT.restDummy.availability.model;

//import com.sun.istack.internal.NotNull;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class AvailabilityServiceValue {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ConcurrentHashMap<String, Boolean> servicesAvailability = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, LocalDateTime> servicesScheduler = new ConcurrentHashMap<>();

    public static class AvailabilityServiceValueHolder {
        static final AvailabilityServiceValue HOLDER_INSTANCE = new AvailabilityServiceValue();
    }

    public static AvailabilityServiceValue getInstance() {
        return AvailabilityServiceValue.AvailabilityServiceValueHolder.HOLDER_INSTANCE;
    }

    public AvailabilityServiceValue initialize(HashMap<String, Boolean> availabilities) {
        for (Map.Entry<String, Boolean> entry : availabilities.entrySet()) {
            servicesAvailability.put(entry.getKey().toLowerCase(), entry.getValue());
        }
        return this;
    }

    public AvailabilityServiceValue initialize(HashMap<String, Boolean> availabilities, HashMap<String, LocalDateTime> schedulers) {
        for (Map.Entry<String, Boolean> entry : availabilities.entrySet()) {
            servicesAvailability.put(entry.getKey().toLowerCase(), entry.getValue());
            servicesScheduler.put(entry.getKey().toLowerCase(Locale.ROOT),
                    schedulers.getOrDefault(
                            entry.getKey().toLowerCase(Locale.ROOT),
                            LocalDateTime.of(2000, 01, 01, 01, 01)));
        }
        return this;
    }

    public AvailabilityServiceValue initialize(boolean isAvailability) {
        for (Map.Entry<String, Boolean> entry : servicesAvailability.entrySet()) {
            servicesAvailability.put(entry.getKey().toLowerCase(), isAvailability);
        }
        return this;
    }

    public boolean getAvailabilityByService(@NonNull String nameOfService) {
        return servicesAvailability.getOrDefault(nameOfService.toLowerCase(), true);
    }

    public LocalDateTime getSchedulerByService(@NonNull String nameOfService) {
        return servicesScheduler.getOrDefault(nameOfService.toLowerCase(), LocalDateTime.of(2000, 01, 01, 01, 01));
    }
    public List<String> getServices() {
        return Collections.list(servicesAvailability.keys());
    }

    public ConcurrentHashMap<String, LocalDateTime> getSchedulers() {
        return servicesScheduler;
    }
    public void setAvailabilityToService(@NonNull String nameOfService, @NonNull boolean availability) {
        final String key = nameOfService.toLowerCase();
        if (servicesAvailability.containsKey(key)) {
            //TODO надо ли удалять?
            servicesAvailability.remove(key);
            servicesAvailability.put(key, availability);
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

}
