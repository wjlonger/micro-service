package com.coder.consumer.service;

import com.coder.base.model.SysRole;
import com.coder.consumer.component.SysRoleServiceHystric;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "provider",fallback = SysRoleServiceHystric.class,path = "/sysrole")
public interface SysRoleService extends com.coder.base.service.SysRoleService {

    @Override
    @RequestLine("POST /selectAll")
    List<SysRole> selectAll(@RequestBody SysRole sysRole);
}
