package com.zhihao.miao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ActApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActApplication.class,args);
    }
}
