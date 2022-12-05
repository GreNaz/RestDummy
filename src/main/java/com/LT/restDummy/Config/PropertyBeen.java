package com.LT.restDummy.Config;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@PropertySource("classpath:delay.properties")
@Slf4j
public class PropertyBeen {

    //     инициализация бина для задержки
    @Bean("Custom_delay")
    public DelayValue delay() {
        HashMap<String, Long> service_delay = new HashMap<>();
        HashMap<String, Long> service_timeout = new HashMap<>();
        HashMap<String, LocalDateTime> service_scheduler = new HashMap<>();
        Properties propertiesDelay = new Properties();
        Properties propertiesTimeout = new Properties();

//        считывание из файла параметров задержки и таймаута
        try {
            InputStream inputDelay = this.getClass().getClassLoader().getResourceAsStream("delay.properties");
            InputStream inputTimeout = this.getClass().getClassLoader().getResourceAsStream("timeout.properties");
            if (inputDelay == null || inputTimeout == null) {
                System.out.println("Sorry, unable to find .properties");
            }
            propertiesDelay.load(inputDelay);
            propertiesTimeout.load(inputTimeout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//          формирование мапы для передачи в класс DelayValue
        for (String key : propertiesDelay.stringPropertyNames()) {
            service_delay.put(key, Long.valueOf(propertiesDelay.getProperty(key)));
            if (propertiesTimeout.containsKey(key)) {
                service_timeout.put(key, Long.valueOf(propertiesTimeout.getProperty(key)));
            }
        }

        return DelayValue.getInstance().initialize(service_delay, service_timeout, service_scheduler);
    }

    //     инициализация бина для доступности сервисов
    @Bean("Availability")
    public AvailabilityServiceValue availability() {
        HashMap<String, Boolean> service_availability = new HashMap<>();
        HashMap<String, LocalDateTime> service_scheduler = new HashMap<>();
        Properties properties = new Properties();

//      считывание из файла параметров задержки и таймаута
        try {
            InputStream inputDelay = this.getClass().getClassLoader().getResourceAsStream("delay.properties");
            properties.load(inputDelay);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //          формирование мапы для передачи в класс DelayValue
        for (String key : properties.stringPropertyNames()) {
            service_availability.put(key, true);
        }
        return AvailabilityServiceValue.getInstance().initialize(service_availability, service_scheduler);
    }



}
