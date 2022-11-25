package com.LT.restDummy.stub.service;

import com.LT.restDummy.date.module.DateModule;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import java.util.Locale;

public class ExampleService {

    static public String getResponse(JSONObject jsonObject){
        String request = jsonObject.toString().toLowerCase(Locale.ROOT);
        String RqUID = StringUtils.substringBetween(request, "\"rquid\":\"", "\"");

        return   "{\n" +
                "    \"rqUID\": \""+RqUID+"\",\n" +
                "    \"rqTm\": \""+ DateModule.get_date_now()+"\",\n" +
                "    \"status \": {\n" +
                "        \"statusCode\": \"0\",\n" +
                "        \"statusDesc\": \"Успех\"\n" +
                "    }\n" +
                "}";
    }
}
