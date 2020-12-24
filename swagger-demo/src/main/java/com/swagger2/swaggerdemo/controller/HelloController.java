package com.swagger2.swaggerdemo.controller;

import com.swagger2.swaggerdemo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello控制器")
@RestController
public class HelloController {

    //默认有2个请求，还有一个是/error
    @GetMapping("/hello")
    public String helloController(){
        return "helloController";
    }

    //只要接口中的返回了实体类，那么这个类就会被扫描到swagger
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    //Operation接口，不是放在类上的
    @ApiOperation("hello的接口")
    @GetMapping("/hello1")
    public String hello1(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("POST的hello2接口")
    @PostMapping("/hello2")
    public User hello2(@ApiParam("用户对象") User user){
//        int i = 5/0;
        return user;
    }

}
