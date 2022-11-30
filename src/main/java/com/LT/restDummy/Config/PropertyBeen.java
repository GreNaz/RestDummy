package com.LT.restDummy.Config;

import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.net.URL;
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



//        FileResourcesUtils app = new FileResourcesUtils();

        try {
            Properties propertiesDelay = new Properties();
            Properties propertiesTimeout = new Properties();
//            TODO почему на сервере не работает?
            propertiesDelay.load(new FileReader(this.getClass().getClassLoader().getResource("delay.properties").getPath()));
//            String uriClass = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//            propertiesDelay.load(new FileReader(uriClass+"/delay.properties"));

//


            propertiesTimeout.load(new FileReader(this.getClass().getClassLoader().getResource("timeout.properties").getPath()));
//            propertiesTimeout.load(new FileReader(uriClass+"/timeout.properties"));

            for (String key : propertiesDelay.stringPropertyNames()) {
                service_delay.put(key, Long.valueOf(propertiesDelay.getProperty(key)));
                if (propertiesTimeout.containsKey(key)) {
                    service_timeout.put(key, Long.valueOf(propertiesTimeout.getProperty(key)));
                }
            }
//            TODO добавить отлов нулпоинтера
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DelayValue.getInstance().initialize(service_delay, service_timeout);

    }


    //     инициализация бина для доступности сервисов
    @Bean("Availability")
    public AvailabilityServiceValue availability() {
        HashMap<String, Boolean> service_availability = new HashMap<>();
        HashMap<String, LocalDateTime> service_scheduler = new HashMap<>();
        try {
            Properties properties = new Properties();
//            String uriClass = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//            properties.load(new FileReader(uriClass+"/delay.properties"));

            properties.load(new FileReader(this.getClass().getClassLoader().getResource("delay.properties").getPath()));
            for (String key : properties.stringPropertyNames()) {
                service_availability.put(key, true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AvailabilityServiceValue.getInstance().initialize(service_availability, service_scheduler);
    }

}
