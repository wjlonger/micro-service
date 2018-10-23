package com.coder.consumer.controller.view;

import com.alibaba.fastjson.JSONObject;
import com.coder.consumer.service.SysMenuService;
import com.coder.base.model.SysMenu;
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

    @GetMapping("/menu")
    public String menu(Model model) {
        List<SysMenu> menus = sysMenuService.selectAll();
        model.addAttribute("data", JSONObject.toJSON(menus));
        return "system/menu";
    }
}
