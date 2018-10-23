package com.coder.consumer.controller.view;

import com.alibaba.fastjson.JSONObject;

import com.coder.base.model.SysPermission;
import com.coder.base.model.SysRole;
import com.coder.consumer.service.SysMenuService;
import com.coder.base.model.SysMenu;
import com.coder.consumer.service.SysPermissionService;
import com.coder.consumer.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/user")
    public String user(Model model) {
        return "system/user";
    }

    @GetMapping("/role")
    public String role(Model model) {
        List<SysRole> roles = sysRoleService.selectAll(null);
        model.addAttribute("data",JSONObject.toJSON(roles));
        List<SysMenu> menus = sysMenuService.selectAll();
        model.addAttribute("allMenus",JSONObject.toJSON(menus));
        List<SysPermission> permissions = sysPermissionService.selectAll(null);
        model.addAttribute("allPermissions",JSONObject.toJSON(permissions));
        return "system/role";
    }

    @GetMapping("/permission")
    public String permission(Model model) {
        return "system/permission";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        List<SysMenu> menus = sysMenuService.selectAll();
        model.addAttribute("data",JSONObject.toJSON(menus));
        return "system/menu";
    }
}
