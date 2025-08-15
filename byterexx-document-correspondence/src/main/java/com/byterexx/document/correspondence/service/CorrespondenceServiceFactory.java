package com.byterexx.document.correspondence.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CorrespondenceServiceFactory {
    private Map<String, com.byterexx.document.correspondence.service.CorrespondenceService> services = new HashMap<>();

    @PostConstruct
    private void init() {
        services.put(com.byterexx.document.correspondence.service.CorrespondenceService.CREATE_CONFIGURATION, null);
        services.put(CorrespondenceService.UPDATE_CONFIGURATION, null);
        services.put(CorrespondenceService.DELETE_CONFIGURATION, null);
        services.put(CorrespondenceService.GET_CONFIGURATION, null);
        services.put(CorrespondenceService.CREATE_TEMPLATE, null);
        services.put(CorrespondenceService.UPDATE_TEMPLATE, null);
        services.put(CorrespondenceService.DELETE_TEMPLATE, null);
        services.put(CorrespondenceService.GET_TEMPLATE, null);
    }

    public <T, K> K service(String serviceType, T request, Map<String, Object> parameters) {
        return (K) services.get(serviceType).service(request, parameters);
    }
}
