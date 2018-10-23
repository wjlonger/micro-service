package com.coder.consumer.service;

import com.coder.base.model.SysPermission;
import com.coder.consumer.component.SysPermissionServiceHystric;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value="provider",fallback = SysPermissionServiceHystric.class,path = "/syspermission")
public interface SysPermissionService extends com.coder.base.service.SysPermissionService {

    @Override
    @RequestLine("POST /selectAll")
    List<SysPermission> selectAll(@RequestBody(required = false) SysPermission sysPermission);
}
