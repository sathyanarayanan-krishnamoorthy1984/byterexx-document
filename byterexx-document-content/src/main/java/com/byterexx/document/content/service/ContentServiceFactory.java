package com.byterexx.document.content.service;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContentServiceFactory {

    private Map<String, ContentService> services = new HashMap<>();

    @PostConstruct
    private void init() {
        services.put(ContentService.CREATE_CONTENT, null);
        services.put(ContentService.UPDATE_CONTENT, null);
        services.put(ContentService.DELETE_CONTENT, null);
        services.put(ContentService.GET_CONTENT, null);
    }

    public <T, K> K service(String serviceType, T request, Map<String, Object> parameters) {
        return (K) services.get(serviceType).service(request, parameters);
    }
}