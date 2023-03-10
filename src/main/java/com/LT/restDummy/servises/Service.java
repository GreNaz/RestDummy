package com.LT.restDummy.servises;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class Service {
    private String name;
    //    Ключ - число для процентного распределения
    private ConcurrentHashMap<Integer, String> response = new ConcurrentHashMap<>();
    //    отсортированные значения распределения
    private List<Integer> thresholds;
    private String fullServiceFile;
    private boolean percentage = false;
    private boolean available = true;
    private LocalDateTime availabilityScheduler = LocalDateTime.of(2000, 01, 01, 01, 01);
    private Long timeout;
    private Long defaultDelay;
    private Long currentDelay;
    private LocalDateTime schedulerToDelay = LocalDateTime.of(2000, 01, 01, 01, 01);
    private Long DelayForScheduler;
    private String type;

}