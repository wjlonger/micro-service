package com.coder.provider.controller;

import com.coder.base.service.RolePermissionService;
import com.coder.base.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @DeleteMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.deleteByPrimaryKey(rolePermission);
    }

    @DeleteMapping("/deleteByProperty")
    public int deleteByProperty(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.deleteByProperty(rolePermission);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.insert(rolePermission);
    }
}
