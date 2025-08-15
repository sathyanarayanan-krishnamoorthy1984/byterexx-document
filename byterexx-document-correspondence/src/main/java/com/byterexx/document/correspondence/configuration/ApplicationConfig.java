package com.byterexx.document.correspondence.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Bean
    FieldValidator fieldValidator() {
        return new FieldValidator();
    }

    @Bean("eStatementConfigDataSource")
    DataSource eStatementConfigDataSource(EStatementMySqlConfiguration mySqlClientConfig) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setJdbcUrl(mySqlClientConfig.getUrl());
        dataSourceConfig.setUsername(mySqlClientConfig.getUsername());
        dataSourceConfig.setPassword(mySqlClientConfig.getPassword());
        dataSourceConfig.setDriverClassName(mySqlClientConfig.getDriver());
        dataSourceConfig.setMaximumPoolSize(5);
        return new HikariDataSource(dataSourceConfig);
    }
}
