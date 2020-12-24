package com.swagger2.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
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
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("1号");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("2号");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("3号");
    }

    @Bean
    public Docket docket(Environment environment) {

        //设置了Swagger的Docket的bean实例
        Profiles profiles = Profiles.of("dev","test");
//        Profiles profiles = Profiles.of("pro","test");

        //获取项目的环境
        //通过环境监听这个变量来判断是否处在自己设定的环境当中
        boolean b = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())


                //.basePackage("com.swagger2.swaggerdemo.controller")   扫描当前路径下的所有包
                //.any              扫描全部
                //.none             都不扫描
                //.withClassAnnotation()    扫描类上的注解，参数是一个注解的反射对象
                //.withMethodAnnotation()    扫描方法上的注解
                .enable(b)      //.enable     是否启用swagger.如果为false，则swagger不能在浏览器中访问
                .groupName("小东")
                .select().apis(RequestHandlerSelectors.basePackage("com.swagger2.swaggerdemo.controller"))
                //.path     只扫描这个路径下的方法，因为controller只有hello没有hello1，所以页面会什么方法都不会显示
//                .paths(PathSelectors.ant("/hello/**"))
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
