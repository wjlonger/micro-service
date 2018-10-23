package com.coder.provider.controller;

import com.coder.base.service.RoleMenuService;
import com.coder.provider.mapper.RoleMenuMapper;
import com.coder.base.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/rolemenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @DeleteMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestBody RoleMenu roleMenu) {
        return roleMenuService.deleteByPrimaryKey(roleMenu);
    }

    @DeleteMapping("/deleteByProperty")
    public int deleteByProperty(@RequestBody RoleMenu roleMenu) {
        return roleMenuService.deleteByProperty(roleMenu);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody RoleMenu roleMenu) {
        return roleMenuService.insert(roleMenu);
    }
}
