package com.LT.restDummy.servises;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceValue {
    private static final ConcurrentHashMap<String, Service> services = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> servicesType = new ConcurrentHashMap<>();

    public static class ServiceValueNewHolder {
        static final ServiceValue HOLDER_INSTANCE = new ServiceValue();
    }

    //        необходимо для использования нестатической переменной в статическом методе
    public static ServiceValue getInstance() {
        return ServiceValue.ServiceValueNewHolder.HOLDER_INSTANCE;
    }

    public ServiceValue initialize(HashMap<String, Service> responses, HashMap<String, String> types) {
        services.putAll(responses);
        servicesType.putAll(types);
        return this;
    }

    public String getTypeByService(String serviceName) {
        return servicesType.get(serviceName);
    }

    public void setTypeByService(String serviceName, String type) {
        servicesType.put(serviceName, type);
    }
    //
    public String getFullFileByService(String serviceName) {
        return services.getOrDefault(serviceName, null).getFullServiceFile();
    }

    public Service getService(String serviceName) {
        return services.getOrDefault(serviceName, null);
    }

    public void setService(String serviceName, Service service) {
        services.put(serviceName, service);
    }

    public void setResponseByService(String serviceName, Service service) {
        services.put(serviceName, service);
    }
}