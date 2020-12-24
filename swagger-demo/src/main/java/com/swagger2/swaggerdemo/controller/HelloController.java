package com.swagger2.swaggerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //默认有2个请求，还有一个是/error
    @RequestMapping("/hello")
    public String helloController(){
        return "helloController";
    }
}
