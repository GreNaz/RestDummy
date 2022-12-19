package com.LT.restDummy.servises;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*Класс хранит названия сервисов и responses*/
@Slf4j
public class ServiceValue {

    private static final ConcurrentHashMap<String, String> servicesResponse = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> servicesType = new ConcurrentHashMap<>();

    public static class ServicesValueHolder {
        static final ServiceValue HOLDER_INSTANCE = new ServiceValue();
    }

    //        необходимо для использования нестатической переменной в статическом методе
    public static ServiceValue getInstance() {
        return ServicesValueHolder.HOLDER_INSTANCE;
    }

    public ServiceValue initialize(HashMap<String, String> responses, HashMap<String, String> types) {
        servicesResponse.putAll(responses);
        servicesType.putAll(types);
        return this;
    }

    public String getTypeByService(String serviceName) {
        return servicesType.get(serviceName);
    }

    public void setTypeByService(String serviceName, String type) {
        servicesType.put(serviceName, type);
    }

    public String getResponseByService(String serviceName) {
        return servicesResponse.getOrDefault(serviceName, "");
    }

    public void setResponseByService(String serviceName, String response) {
        servicesResponse.put(serviceName, response);
    }
}
