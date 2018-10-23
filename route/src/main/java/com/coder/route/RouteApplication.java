package com.coder.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class RouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouteApplication.class,args);
    }

}
