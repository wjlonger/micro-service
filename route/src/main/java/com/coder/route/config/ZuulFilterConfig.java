package com.coder.route.config;

import com.coder.route.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}
