package com.byterexx.document.correspondence.configuration;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("vcap.services.mysql-estatement-config.credentials")
@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class DocumentMySqlConfiguration {
    private String url; // no usages
    private String username; // no usages
    private String password; // no usages
    private String driver; // no usages
}