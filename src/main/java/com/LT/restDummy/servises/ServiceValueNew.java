package com.LT.restDummy.servises;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceValueNew {
    private static final ConcurrentHashMap<String, Service> services = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> servicesType = new ConcurrentHashMap<>();

    public static class ServiceValueNewHolder {
        static final ServiceValueNew HOLDER_INSTANCE = new ServiceValueNew();
    }

    //        необходимо для использования нестатической переменной в статическом методе
    public static ServiceValueNew getInstance() {
        return ServiceValueNew.ServiceValueNewHolder.HOLDER_INSTANCE;
    }

    public ServiceValueNew initialize(HashMap<String, Service> responses, HashMap<String, String> types) {
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