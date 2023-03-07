package com.LT.restDummy.controller;


import com.LT.restDummy.availability.model.AvailabilityValue;
import com.LT.restDummy.delay.model.DelayValue;
import com.LT.restDummy.delay.model.ViewDelayData;
import com.LT.restDummy.delay.model.ViewDelayDataDTO;
import com.LT.restDummy.file.FileWork;
import com.LT.restDummy.servises.ServiceValue;
import com.LT.restDummy.servises.ViewServiceData;
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
    private final AvailabilityValue availabilityValue;
    private final ServiceValue serviceValue;

    @Autowired
    public DelayController(DelayValue delayValue, AvailabilityValue availabilityValue, ServiceValue serviceValue) {
        this.delayValue = delayValue;
        this.availabilityValue = availabilityValue;
        this.serviceValue = serviceValue;
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
            delayValue.setNewDelayToService(service.getName(), service.getCurrentDelay());
            delayValue.setNewDelayToScheduler(service.getName(), service.getDelayForScheduler());
            delayValue.setSchedulerToService(service.getName(), LocalDateTime.parse(service.getSchedulerDelay(), DATE_TIME_FORMATTER));
            availabilityValue.setAvailabilityToService(service.getName(), service.getIsAvailable());
            availabilityValue.setSchedulerToService(service.getName(), LocalDateTime.parse(service.getSchedulerAvailability(), DATE_TIME_FORMATTER));
        }
        return "redirect:/delay";
    }

    //  ставит отклик -10% от таймаута
    @RequestMapping("/delay/calculate")
    public String calculateDelaySet() {
        DelayValue.getInstance().setMinus10PercentDelay();
        return "redirect:/delay";
    }

    //    вернуть дефолтные задержки
    @RequestMapping("/delay/default")
    public String defaultDelaySet() {
        DelayValue.getInstance().initialize(DelayValue.getInstance().getServicesDefaultDelay());
        return "redirect:/delay";
    }

    //    включить все сервисы
    @RequestMapping("/delay/enableServices")
    public String enableServices() {
        AvailabilityValue.getInstance().initialize(true);
        return "redirect:/delay";
    }

    //    выключить все сервисы
    @RequestMapping("/delay/disableServices")
    public String disableServices() {
        AvailabilityValue.getInstance().initialize(false);
        return "redirect:/delay";
    }

    @RequestMapping("/services/add")
    public String addService(Model model) {
        ViewServiceData viewServiceData = new ViewServiceData("", "");
        model.addAttribute("viewServiceData", viewServiceData);
        return "newServices";
    }

    //    Сохранение сервиса. Если есть параметр эндпоинта, то он становится именем сервиса(но не файла)
    @RequestMapping(value = "/services/save")
    public String saveAddForm(@ModelAttribute(name = "viewServiceData") ViewServiceData viewData, Model model) {
        String ServiceNameOrEndpoint = FileWork.getContentEndPoint(viewData.getContent());
        FileWork.fullFile(viewData.getServiceName(), viewData.getContent());
        if (ServiceNameOrEndpoint == null) {
            ServiceNameOrEndpoint = viewData.getServiceName();
        }

        serviceValue.setService(ServiceNameOrEndpoint,
                FileWork.getService(viewData.getContent()));
        serviceValue.setTypeByService(ServiceNameOrEndpoint,
                FileWork.getContentType(viewData.getContent()));
        delayValue.setNewService(ServiceNameOrEndpoint,
                FileWork.getContentDelay(viewData.getContent()),
                FileWork.getContentTimeout(viewData.getContent()));
        availabilityValue.setAvailabilityToService(ServiceNameOrEndpoint, true);
        availabilityValue.setDefaultSchedulerAvailability(ServiceNameOrEndpoint);
        return "redirect:/delay";
    }

    @RequestMapping(value = "/services/update")
    public String updateForm(@ModelAttribute(name = "viewServiceData") ViewServiceData viewData, Model model) {
        String content = serviceValue.getFullFileByService(viewData.getServiceName());
        if (content == null || content.isEmpty()) {
            viewData.setContent("Файла не существует или он пуст.");
        } else {
            viewData.setContent(content);
        }
        model.addAttribute("viewServiceData", viewData);
        return "newServices";
    }

    private Model getForm(Model model) {
        List<String> services = delayValue.getServices();
        List<ViewDelayData> dataList = new ArrayList<>();
        ViewDelayDataDTO form = new ViewDelayDataDTO();
        for (String item : services) {
            dataList.add(new ViewDelayData(item,
                    delayValue.getDelayByService(item),
                    delayValue.getTimeoutByService(item),
                    delayValue.getSchedulerDelayByService(item),
                    delayValue.getSchedulerByService(item).format(DATE_TIME_FORMATTER),
                    availabilityValue.getAvailabilityByService(item),
                    availabilityValue.getSchedulerByService(item).format(DATE_TIME_FORMATTER)));
        }
        for (ViewDelayData item : dataList) {
            form.addViewDelayData(item);
        }
        model.addAttribute("form", form);
        return model;
    }
}