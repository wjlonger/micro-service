package com.coder.consumer.service;

import com.coder.consumer.component.SysMenuServiceHystric;
import com.coder.base.model.SysMenu;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value="provider",fallback = SysMenuServiceHystric.class,path = "/sysmenu")
public interface SysMenuService extends com.coder.base.service.SysMenuService {

    @Override
    @RequestLine("GET /selectAll")
    List<SysMenu> selectAll();

    @Override
    @RequestLine("POST /save")
    int save(@RequestBody SysMenu sysMenu);

    @Override
    @RequestLine("POST /selectByPrimaryKey/{id}")
    SysMenu selectByPrimaryKey(@Param("id") Integer id);

    @Override
    @RequestLine("DELETE /deleteByPrimaryKey/{id}")
    int deleteByPrimaryKey(@Param("id") Integer id);
}
