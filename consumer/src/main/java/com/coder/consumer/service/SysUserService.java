package com.coder.consumer.service;

import com.coder.consumer.component.SysUserServiceHystric;
import com.coder.base.model.SysUser;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="provider",fallback = SysUserServiceHystric.class,path = "/sysuser")
public interface SysUserService {

    /**
     * 在 FeignConfig  如果配置了 Feign ,那么请求的时候只能用 Feign自己的参数请求，使用SpringMVC的请求就会出错
     * 这里配置了 FeignConfig，所以就只能使用 @RequestLine
     * RequestMapping("/selectByProperty")
     * @param sysUser
     * @return
     */
    @RequestLine("POST /selectbyproperty")
    SysUser selectByProperty(@RequestBody SysUser sysUser);

}
