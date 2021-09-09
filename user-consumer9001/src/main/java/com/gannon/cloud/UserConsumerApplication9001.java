package com.gannon.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class UserConsumerApplication9001 {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return  new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication9001.class, args);
    }
}
