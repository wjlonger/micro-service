package com.coder.consumer.component;

import com.coder.base.model.RolePermission;
import com.coder.consumer.service.RolePermissionService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolePermissionServiceHystric implements RolePermissionService {

    @Override
    public int deleteByPrimaryKey(RolePermission rolePermission) {
        return 0;
    }

    @Override
    public int deleteByProperty(RolePermission rolePermission) {
        return 0;
    }

    @Override
    public int insert(RolePermission rolePermission) {
        return 0;
    }
}
