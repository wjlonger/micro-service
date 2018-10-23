package com.coder.consumer.service;

import com.coder.base.model.RolePermission;
import com.coder.consumer.component.RolePermissionServiceHystric;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="provider",fallback = RolePermissionServiceHystric.class,path = "/rolepermission")
public interface RolePermissionService extends com.coder.base.service.RolePermissionService {

    @Override
    @RequestLine("DELETE /deleteByPrimaryKey")
    int deleteByPrimaryKey(@RequestBody RolePermission rolePermission);

    @Override
    @RequestLine("DELETE /deleteByProperty")
    int deleteByProperty(@RequestBody RolePermission rolePermission);

    @Override
    @RequestLine("POST /insert")
    int insert(@RequestBody RolePermission rolePermission);

}
