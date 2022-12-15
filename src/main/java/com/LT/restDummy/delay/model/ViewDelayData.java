package com.LT.restDummy.delay.model;

import lombok.Getter;
import lombok.Setter;

/*Необходим для отображения через GUI*/
@Getter
@Setter
public class ViewDelayData {

    private String name;
    private Long currentDelay;
    private Long timeout;
    private Long delayForScheduler;
    private String schedulerDelay;
    private Boolean isAvailable;
    private String schedulerAvailability;

    public ViewDelayData(String name, Long currentDelay, Long timeout, Long delayForScheduler, String schedulerDelay, Boolean isAvailable, String schedulerAvailability) {
        this.name = name;
        this.currentDelay = currentDelay;
        this.timeout = timeout;
        this.delayForScheduler = delayForScheduler;
        this.schedulerDelay = schedulerDelay;
        this.isAvailable = isAvailable;
        this.schedulerAvailability = schedulerAvailability;
    }

    //    Не удалять. Без него ломается HTML
    public ViewDelayData() {
        this.name = "rand";
        this.currentDelay = 0L;
        this.timeout = 0L;
        this.isAvailable = false;
    }

}
