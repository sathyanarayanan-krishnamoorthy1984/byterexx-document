package com.byterexx.document.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DDAReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(DDAReportApplication.class);
    }
}
