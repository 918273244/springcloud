package com.zhihao.miao.cloud;

import com.zhihao.miao.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservice-provider-user", configuration = TestConfiguration.class)
public class MoviceApplication {

    //配置了@LoadBalanced表示默认的轮询策略，使用了@RibbonClient表明了可以定制服务的轮询策略，定制的策略就是configuration值，不要将
    //configuration的类放到Application启动类的@ComponentScan路径下，这样会将所有服务的轮询策略都用configuration配置的策略所代替
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviceApplication.class,args);
    }
}
