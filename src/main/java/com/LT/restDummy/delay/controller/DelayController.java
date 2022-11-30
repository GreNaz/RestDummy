package com.LT.restDummy.delay.controller;


import com.LT.restDummy.availability.model.AvailabilityServiceValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.model.ViewDelayData;
import com.LT.restDummy.delay.model.ViewDelayDataDTO;
import com.LT.restDummy.stub.helper.DummyHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*Класс взаимодействует с фронтом(html) и управляет задержкой и доступностью сервисов*/


@Slf4j
@Controller
public class DelayController {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final DelayValue delayValue;
    private final AvailabilityServiceValue availabilityServiceValue;

    @Autowired
    public DelayController(DelayValue delayValue, AvailabilityServiceValue availabilityServiceValue) {
        this.delayValue = delayValue;
        this.availabilityServiceValue = availabilityServiceValue;
    }

    //  страница с информацией по доступности сервиса, задержке и таймаутам
    @GetMapping("/delay")
    public String showNewDelayForm(Model model) {
        getForm(model);
        return "delay";
    }



    //  страница редактирования доступности сервиса и задержки
    @GetMapping(value = "/delay/edit")
    public String editDelayForm(Model model) {
        getForm(model);
        return "edit";
    }

    //    сохранение информации после редактирования
    @RequestMapping(value = "/delay/save")
    public String saveEditForm(@ModelAttribute(name = "form") ViewDelayDataDTO viewData, Model model) {
        for (ViewDelayData service : viewData.getViewData()) {
            delayValue.setNewDelayToService(service.getName(), service.getDelay());
            availabilityServiceValue.setAvailabilityToService(service.getName(), service.getIsAvailable());
            availabilityServiceValue.setSchedulerToService(service.getName(), LocalDateTime.parse(service.getScheduler(), DATE_TIME_FORMATTER));
//            availabilityServiceValue.setSchedulerToService(service.getName(), service.getScheduler());
        }
        return "redirect:/delay";
    }

    //  ставит отклик -10% от таймаута
    @RequestMapping("/delay/calculate")
    public String calculateDelaySet() {
        DelayValue.getInstance().calculate10Delay();
        return "redirect:/delay";
    }

    @RequestMapping("/delay/default")
    public String defaultDelaySet() {
        DelayValue.getInstance().initialize(DelayValue.getInstance().getServicesDefaultDelay());
        return "redirect:/delay";
    }

    @RequestMapping("/delay/enableServices")
    public String enableServices() {
        AvailabilityServiceValue.getInstance().initialize(true);
        return "redirect:/delay";
    }

    @RequestMapping("/delay/disableServices")
    public String disableServices() {
        AvailabilityServiceValue.getInstance().initialize(false);
        return "redirect:/delay";
    }

    private Model getForm(Model model) {
        List<String> services = delayValue.getServices();
        List<ViewDelayData> dataList = new ArrayList<>();
        ViewDelayDataDTO form = new ViewDelayDataDTO();
        for (String item : services) {
            dataList.add(new ViewDelayData(item,
                    delayValue.getDelayByService(item),
                    delayValue.getTimeoutByService(item),
                    availabilityServiceValue.getAvailabilityByService(item),
                    availabilityServiceValue.getSchedulerByService(item).format(DATE_TIME_FORMATTER)));
//            availabilityServiceValue.getSchedulerByService(item)));
        }
        for (ViewDelayData item : dataList) {
            form.addViewDelayData(item);
        }
        model.addAttribute("form", form);
        return model;
    }



}
