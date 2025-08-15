package com.byterexx.document.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude =  {DataSourceAutoConfiguration.class})
public class DocumentContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentContentApplication.class);
    }
}
