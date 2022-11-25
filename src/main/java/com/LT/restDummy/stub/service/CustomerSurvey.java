package com.LT.restDummy.stub.service;

import org.json.simple.JSONObject;

public class CustomerSurvey {
    static public String getResponse(JSONObject jsonObject){
//        String request = jsonObject.toString().toLowerCase(Locale.ROOT);
//        String RqUID = StringUtils.substringBetween(request, "\"rquid\":\"", "\"");

        return   "{\n" +
                "    \"success\": true,\n" +
                "    \"body\": {\n" +
                "        \"type\": \"SurveyStarsEntryPoint\",\n" +
                "        \"title\": \"Оцените пользу экрана задолженности\",\n" +
                "        \"description\": \"Расскажите подробнее о вашем опыте. Это займёт всего три минуты\",\n" +
                "        \"properties\": {\n" +
                "            \"buttonName\": \"Пройти опрос\",\n" +
                "            \"deeplink\": \"sberbankonline://start-survey?bottomSheet=true&cmId=1006512\",\n" +
                "            \"launcherFeatureName\": \"CreditCardsDsmoEntryPoint\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
