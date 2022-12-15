package com.LT.restDummy.file;

import com.google.common.io.Files;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Класс для работы с файлами и данными из файлов*/
@Slf4j
public class FileWork {


    @SneakyThrows
    public static void fullFile(String fileName, String content) {
        File directory = new File("services");
        File file = new File(directory, fileName);
        byte[] strToBytes = content.getBytes();

        Files.write(strToBytes, file);
    }

    public static String getContentResponse(String content) {
        Matcher matcher = Pattern.compile("---([\\s\\S]+?)---").matcher(content);
        while (matcher.find()) {
            return StringUtils.replace(content, matcher.group(), "").replaceAll(": \"", ":\"");
        }
        if (!content.isEmpty()) {
            return content;
        } else {
            return "Текст сервиса не найден";
        }

    }

    public static String getContentType(String content) {
        Matcher matcher = Pattern.compile("type=(.+?);").matcher(content);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return "Type не найден";
    }

    public static long getContentDelay(String content) {
        Matcher matcher = Pattern.compile("delay=(.+?);").matcher(content);
        while (matcher.find()) {
            return Long.valueOf(matcher.group(1));
        }
        return 1000;
    }

    public static long getContentTimeout(String content) {
        Matcher matcher = Pattern.compile("timeout=(.+?);").matcher(content);
        while (matcher.find()) {
            return Long.valueOf(matcher.group(1));
        }
        return 0;
    }

    public static String getContentEndPoint(String content) {
        Matcher matcher = Pattern.compile("endpoint=(.+?);").matcher(content);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static ArrayList<String> getListFilesForFolder(final File folder) {
        if (!folder.exists()) {
            folder.mkdir();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getListFilesForFolder(fileEntry);
            } else {
                arrayList.add(fileEntry.getName());
            }
        }
        return arrayList;
    }

    //    Вытаскиваем сабсистем или создаем файл-уведомление
    public static Properties getInfluxProperty() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("properties"));
        } catch (IOException e) {
            log.error("Вы не заполнили файл properties с параметром subsystem=VASHA_SUBSYSTEM");
        }
        return properties;
    }
}
