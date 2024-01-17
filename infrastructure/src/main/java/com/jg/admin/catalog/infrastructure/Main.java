package com.jg.admin.catalog.infrastructure;

import com.jg.admin.catalog.application.UseCase;
import com.jg.admin.catalog.infrastructure.configuration.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(WebServerConfig.class, args);

    }
}