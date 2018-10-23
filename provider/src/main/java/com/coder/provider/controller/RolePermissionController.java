package com.coder.provider.controller;

import com.coder.base.service.RolePermissionService;
import com.coder.provider.mapper.RolePermissionMapper;
import com.coder.base.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    public int deleteByPrimaryKey(RolePermission rolePermission) {
        return rolePermissionService.deleteByPrimaryKey(rolePermission);
    }

    public int deleteByProperty(RolePermission rolePermission) {
        return rolePermissionService.deleteByProperty(rolePermission);
    }

    public int insert(RolePermission rolePermission) {
        return rolePermissionService.insert(rolePermission);
    }
}
