package com.zhihao.miao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Act2Application {
    public static void main(String[] args) {
        SpringApplication.run(Act2Application.class,args);
    }
}
