package com.coder.consumer.service;

import com.coder.consumer.component.TestServiceHystric;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="provider",fallback = TestServiceHystric.class)
public interface TestService {

    @RequestLine("GET /test")
    String testFromClient();
}
