package com.LT.restDummy.servises;

import com.LT.restDummy.servises.dto.ServiceRequestDto;

public class ServiceMapper {
    ServiceValue serviceValue;

    public ServiceMapper(ServiceValue serviceValue) {
        this.serviceValue = serviceValue;
    }

    public static ServiceRequestDto serviceToDto(Service service) {
        return new ServiceRequestDto(service.getName(),
                service.getDefaultDelay(),
                service.getCurrentDelay(),
                service.getTimeout(),
                service.isAvailable());
    }

    public static Service dtoToService(ServiceRequestDto serviceRequestDto) {
        return new Service(serviceRequestDto.getName(),
                serviceRequestDto.getDelay(),
                serviceRequestDto.isAvailable());
    }
}
