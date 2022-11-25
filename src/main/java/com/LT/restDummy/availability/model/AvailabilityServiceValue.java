package com.LT.restDummy.availability.model;

//import com.sun.istack.internal.NotNull;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class AvailabilityServiceValue {
    private static final ConcurrentHashMap<String, Boolean> servicesAvailability = new ConcurrentHashMap<>();

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

    public AvailabilityServiceValue initialize(boolean isAvailability) {
        for (Map.Entry<String, Boolean> entry : servicesAvailability.entrySet()) {
            servicesAvailability.put(entry.getKey().toLowerCase(), isAvailability);
        }
        return this;
    }

    public boolean getAvailabilityByService(@NonNull String nameOfService) {
        return servicesAvailability.getOrDefault(nameOfService.toLowerCase(), true);
    }

    public List<String> getServices() {
        return Collections.list(servicesAvailability.keys());
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

}
