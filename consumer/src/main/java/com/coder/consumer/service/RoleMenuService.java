package com.coder.consumer.service;

import com.coder.base.model.RoleMenu;
import com.coder.consumer.component.RoleMenuServiceHystric;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="provider",fallback = RoleMenuServiceHystric.class,path = "/rolemenu")
public interface RoleMenuService extends com.coder.base.service.RoleMenuService {

    @Override
    @RequestLine("DELETE /deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestBody RoleMenu roleMenu);

    @Override
    @RequestLine("DELETE /deleteByProperty")
    int deleteByProperty(@RequestBody() RoleMenu roleMenu);

    @Override
    @RequestLine("POST /insert")
    int insert(@RequestBody RoleMenu roleMenu);

}
