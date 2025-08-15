package com.byterexx.document.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean (String name, Class <T> type) {
        return applicationContext.getBean(name, type);
    }

    public static Object getBean (String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean (Class <T> type) {
        return applicationContext.getBean(type);
    }
}
