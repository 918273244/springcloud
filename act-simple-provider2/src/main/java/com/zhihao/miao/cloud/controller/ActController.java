package com.zhihao.miao.cloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/act")
public class ActController {

    @GetMapping("/home")
    public String act(){
        return "act home";
    }

}
