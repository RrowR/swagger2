package com.swagger2.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2     //开启swagger
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //.basePackage("com.swagger2.swaggerdemo.controller")   扫描当前路径下的所有包
                //.any              扫描全部
                //.none             都不扫描
                //.withClassAnnotation()    扫描类上的注解，参数是一个注解的反射对象
                //.withMethodAnnotation()    扫描方法上的注解
                .select().apis(RequestHandlerSelectors.basePackage("com.swagger2.swaggerdemo.controller"))
                //.path     只扫描这个路径下的方法，因为controller只有hello没有hello1，所以页面会什么方法都不会显示
                .paths(PathSelectors.ant("/hello/**"))
                .build();
    }

    //配置swagger信息=apiInfo(apiInfo)
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("黄晓东", "https://bbs.zombieden.cn/", "2415782224@qq.com");
        return new ApiInfo(
                "黄晓东的api文档",
                "这个是一个swagger文档",
                "1.0",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
