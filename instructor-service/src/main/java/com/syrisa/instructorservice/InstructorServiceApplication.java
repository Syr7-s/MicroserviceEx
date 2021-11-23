package com.syrisa.instructorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InstructorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructorServiceApplication.class, args);
    }

}
