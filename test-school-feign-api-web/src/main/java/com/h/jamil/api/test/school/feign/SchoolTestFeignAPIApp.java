package com.h.jamil.api.test.school.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableFeignClients
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = "com.h.jamil.api.test.school.feign")
public class SchoolTestFeignAPIApp {

    public static void main(String[] args) {
        SpringApplication.run(SchoolTestFeignAPIApp.class, args);
    }
}
