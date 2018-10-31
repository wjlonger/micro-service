package com.coder.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RefreshScope
public class HomeController {

    @Value("${version}")
    private String version;

    @RequestMapping("/version")
    public String version(){
        return version;
    }
}
