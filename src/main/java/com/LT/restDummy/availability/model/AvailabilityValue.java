package com.LT.restDummy.availability.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*Класс отвечает за доступность сервисов*/
@Slf4j
public class AvailabilityValue {
    private static final ConcurrentHashMap<String, Boolean> servicesAvailability = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, LocalDateTime> AvailabilityScheduler = new ConcurrentHashMap<>();

    public static class AvailabilityServiceValueHolder {
        static final AvailabilityValue HOLDER_INSTANCE = new AvailabilityValue();
    }

    public static AvailabilityValue getInstance() {
        return AvailabilityValue.AvailabilityServiceValueHolder.HOLDER_INSTANCE;
    }

    public AvailabilityValue initialize(HashMap<String, Boolean> availabilities, HashMap<String, LocalDateTime> schedulers) {
        for (Map.Entry<String, Boolean> entry : availabilities.entrySet()) {
            servicesAvailability.put(entry.getKey(), entry.getValue());
            AvailabilityScheduler.put(entry.getKey(),
                    schedulers.getOrDefault(
                            entry.getKey(),
                            LocalDateTime.of(2000, 01, 01, 01, 01)));
        }
        return this;
    }

    public AvailabilityValue initialize(boolean isAvailability) {
        for (Map.Entry<String, Boolean> entry : servicesAvailability.entrySet()) {
            servicesAvailability.put(entry.getKey(), isAvailability);
        }
        return this;
    }

    public boolean getAvailabilityByService(@NonNull String nameOfService) {
        return servicesAvailability.getOrDefault(nameOfService, true);
    }

    public LocalDateTime getSchedulerByService(@NonNull String nameOfService) {
        return AvailabilityScheduler.getOrDefault(nameOfService, LocalDateTime.of(2000, 01, 01, 01, 01));
    }


    public ConcurrentHashMap<String, LocalDateTime> getSchedulers() {
        return AvailabilityScheduler;
    }

    public void setAvailabilityToService(@NonNull String nameOfService, @NonNull boolean availability) {
        servicesAvailability.put(nameOfService, availability);
    }

    public void setDefaultSchedulerAvailability(@NonNull String nameOfService) {
        AvailabilityScheduler.put(nameOfService, LocalDateTime.of(2000, 01, 01, 01, 01));

    }

    public void setSchedulerToService(@NonNull String nameOfService, @NonNull LocalDateTime scheduler) {
        if (AvailabilityScheduler.containsKey(nameOfService)) {
            AvailabilityScheduler.put(nameOfService, scheduler);
        } else
            log.error("Cant set new value for '{}', service not found", nameOfService);
    }

}
