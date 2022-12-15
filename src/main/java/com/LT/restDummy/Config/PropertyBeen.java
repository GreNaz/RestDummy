package com.LT.restDummy.Config;

import com.LT.restDummy.availability.model.AvailabilityValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.file.FileWork;
import com.LT.restDummy.servises.ServiceValue;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/*Класс создает бины для работы с сервисами, их задержками и доступностью.
Инициализирует сервисы из файлов, если они есть в папке*/
@Configuration
@Slf4j
public class PropertyBeen {
    ArrayList<String> allFiles = FileWork.getListFilesForFolder(new File("services"));

    @SneakyThrows
    @Bean("CustomDelay")
    public DelayValue delayFileEdition() {
        HashMap<String, Long> service_delay = new HashMap<>();
        HashMap<String, Long> service_timeout = new HashMap<>();
        HashMap<String, LocalDateTime> service_scheduler = new HashMap<>();
        for (String allFile : allFiles) {
            BufferedReader reader = new BufferedReader(new FileReader("services/" + allFile));
            String response = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            String endpoint = FileWork.getContentEndPoint(response);
            if (endpoint != null) {
                service_delay.put(endpoint, FileWork.getContentDelay(response));
                service_timeout.put(endpoint, FileWork.getContentTimeout(response));
            } else {
                service_delay.put(allFile, FileWork.getContentDelay(response));
                service_timeout.put(allFile, FileWork.getContentTimeout(response));
            }
        }
        return DelayValue.getInstance().initialize(service_delay, service_timeout, service_scheduler);
    }

    @SneakyThrows
    @Bean("Availability")
    public AvailabilityValue availability() {
        HashMap<String, Boolean> service_availability = new HashMap<>();
        HashMap<String, LocalDateTime> service_scheduler = new HashMap<>();
        for (String allFile : allFiles) {
            BufferedReader reader = new BufferedReader(new FileReader("services/" + allFile));
            String response = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            String endpoint = FileWork.getContentEndPoint(response);
            if (endpoint != null) {
                service_availability.put(endpoint, true);

            } else {
                service_availability.put(allFile, true);
            }
        }
        return AvailabilityValue.getInstance().initialize(service_availability, service_scheduler);
    }

    @Bean("Services")
    @SneakyThrows
    public ServiceValue getFileServices() {
        HashMap<String, String> services = new HashMap<>();
        HashMap<String, String> types = new HashMap<>();

        for (String allFile : allFiles) {
            BufferedReader reader = new BufferedReader(new FileReader("services/" + allFile));
            String response = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            String endpoint = FileWork.getContentEndPoint(response);
            if (endpoint != null) {
                services.put(endpoint, FileWork.getContentResponse(response));
                types.put(endpoint, FileWork.getContentType(response));
            } else {
                services.put(allFile, FileWork.getContentResponse(response));
                types.put(allFile, FileWork.getContentType(response));
            }
        }
        return ServiceValue.getInstance().initialize(services, types);
    }
}
