package com.byterexx.document.content.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    FieldValidator fieldValidator() {
        return new FieldValidator();
    }
}
