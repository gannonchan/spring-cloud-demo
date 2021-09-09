package com.gannon.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserProviderApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication8003.class, args);
    }
}