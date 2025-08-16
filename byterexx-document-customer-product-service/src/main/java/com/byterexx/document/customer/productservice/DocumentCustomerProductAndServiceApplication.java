package com.byterexx.document.customer.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DocumentCustomerProductAndServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentCustomerProductAndServiceApplication.class, args);
    }
}
