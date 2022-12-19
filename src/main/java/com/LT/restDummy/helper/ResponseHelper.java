package com.LT.restDummy.helper;

import com.LT.restDummy.availability.model.AvailabilityValue;
import com.LT.restDummy.date.DateModule;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.service.ResponseDelay;
import com.LT.restDummy.exception.ServiceException;
import com.LT.restDummy.servises.ServiceValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Класс помощник для работы с ответами сервисов*/
@Slf4j
public class ResponseHelper {

    public static CompletableFuture<ResponseEntity<String>> returnResponse(String request, String serviceName,
                                                                           long delay,
                                                                           Boolean isAvailable) {
        log.info("REQUEST: " + request);
        // Если параметры заданы, то обновляем их
        if (delay != 0) {
            DelayValue.getInstance().setNewDelayToService(serviceName, delay);
        }
        if (isAvailable != null) {
            AvailabilityValue.getInstance().setAvailabilityToService(serviceName, isAvailable);
        }
        // Если сервис доступен, то возвращаем его
        if (AvailabilityValue.getInstance().getAvailabilityByService(serviceName)) {
//            передаем параметры для задержки: секунды, закорелированный ответ и сервис
            return ResponseDelay.scheduleResponse(DelayValue.getInstance().getDelayByService(serviceName),
                    responseCorrelate(request,
                            ServiceValue.getInstance().getResponseByService(serviceName),
                            ServiceValue.getInstance().getTypeByService(serviceName)),
                    serviceName);
        } else throw new ServiceException("Сервис временно недоступен. Включите заглушку");
    }

    public static String parameterCorrelate(String request, String param, String type) {
        request = request.toLowerCase(Locale.ROOT).replaceAll("\\s+", "");
        param = param.toLowerCase(Locale.ROOT);
        switch (type.toLowerCase(Locale.ROOT)) {
            case "xml":
                return StringUtils.substringBetween(request, "<" + param + ">", "</" + param + ">");
            case "json":
                return StringUtils.substringBetween(request, "\"" + param + "\":\"", "\"");
            default:
                return "null";
        }
    }

    //
    public static String responseCorrelate(String request, String response, String type) {
//       собираем все параметры, необходимые к замене
        Matcher matcher = Pattern.compile("__([a-zA-Z0-9]+)__").matcher(response);
        ArrayList<String> params = new ArrayList<>();
        while (matcher.find()) {
            params.add(matcher.group(1));
        }

        Pattern patternResponse;
        for (String param : params) {
//            Собираем подстроку которую нужно будет заменить в ответе. Пример: __RqUID__
            switch (type) {
                case "xml":
                    patternResponse = Pattern.compile("<" + param + ">(__[a-zA-Z0-9]*__)<");
                    break;
                case "json":
                default:
                    patternResponse = Pattern.compile("\"" + param + "\":\"(__[a-zA-Z0-9]*__)\"");
                    break;
            }
//            String lowerCaseResponse = response.toLowerCase(Locale.ROOT);
            Matcher matcherResponse = patternResponse.matcher(response);
            while (matcherResponse.find()) {
//            Заменяем найденную подстроку на значение из запроса или текущее время
                if (param.equalsIgnoreCase("rqtm")) {
                    response = StringUtils.replace(response, matcherResponse.group(1), DateModule.get_date_now());
                } else {
                    response = StringUtils.replace(response, matcherResponse.group(1), parameterCorrelate(request, param, type));
                }
            }
        }
        return response;
    }
}

