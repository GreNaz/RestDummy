package com.LT.restDummy.servises;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Getter
@Setter
public class Service {
    //    ключ число для рандома
    String fullServiceFile;
//    List<Integer> thresholds; TODO !!!
    ConcurrentHashMap<Integer, String> response = new ConcurrentHashMap<>();
    boolean percentage = false;
}