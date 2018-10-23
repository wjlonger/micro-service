package com.coder.consumer.component;

import com.coder.consumer.service.TestService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestServiceHystric implements TestService {

    @Override
    public String testFromClient() {
        return "is error";
    }
}
