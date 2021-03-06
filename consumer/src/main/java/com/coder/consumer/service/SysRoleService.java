package com.coder.consumer.service;

import com.coder.base.model.SysRole;
import com.coder.consumer.component.SysRoleServiceHystric;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "provider",fallback = SysRoleServiceHystric.class,path = "/sysrole")
public interface SysRoleService extends com.coder.base.service.SysRoleService {

    @Override
    @RequestLine("POST /selectAll")
    List<SysRole> selectAll(@RequestBody(required = false) SysRole sysRole);

    @Override
    @RequestLine("GET /selectByPrimaryKey/{id}")
    SysRole selectByPrimaryKey(@Param("id") Integer rid);

    @Override
    @RequestLine("POST /save")
    SysRole save(@RequestBody SysRole sysRole);

    @Override
    @RequestLine("DELETE /deleteByPrimaryKey/{id}")
    int deleteByPrimaryKey(@Param("id") Integer rid);
}
