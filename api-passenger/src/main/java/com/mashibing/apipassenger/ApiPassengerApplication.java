package com.mashibing.apipassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// 这个注解说明是启动类
public class ApiPassengerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ApiPassengerApplication.class);
    }
}
