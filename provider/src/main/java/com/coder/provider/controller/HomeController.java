package com.coder.provider.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HomeController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
