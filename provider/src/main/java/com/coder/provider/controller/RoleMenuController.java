package com.coder.provider.controller;

import com.coder.base.service.RoleMenuService;
import com.coder.provider.mapper.RoleMenuMapper;
import com.coder.base.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/rolemenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    public int deleteByPrimaryKey(RoleMenu roleMenu) {
        return roleMenuService.deleteByPrimaryKey(roleMenu);
    }

    public int deleteByProperty(RoleMenu roleMenu) {
        return roleMenuService.deleteByProperty(roleMenu);
    }

    public int insert(RoleMenu roleMenu) {
        return roleMenuService.insert(roleMenu);
    }
}
