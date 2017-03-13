package com.zhihao.miao.cloud.controller;

import com.zhihao.miao.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movice")
public class MoviceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("microservice-provider-user" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost()
                + ":" + serviceInstance.getPort());
        return restTemplate.getForObject("http://microservice-provider-user/user/simple/"+id,User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println();
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("act-simple-provider");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        return "1";
    }



}
