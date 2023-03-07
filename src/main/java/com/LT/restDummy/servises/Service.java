package com.LT.restDummy.servises;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class Service {
    //    Ключ - число для процентного распределения
    ConcurrentHashMap<Integer, String> response = new ConcurrentHashMap<>();
    //    отсортированные значения распределения
    List<Integer> thresholds;
    String fullServiceFile;
    boolean percentage = false;
}