package com.coder.consumer.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.coder.base.model.SysMenu;
import com.coder.consumer.service.SysMenuService;
import com.coder.consumer.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/menu")
public class SystemMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping()
    public String save(SysMenu sysMenu){
        int i = sysMenuService.save(sysMenu);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            SysMenu menu = sysMenuService.selectByPrimaryKey(sysMenu.getPid());
            json.put("menu",menu);
        }
        return json.toJSONString();
    }

    @PostMapping("/parentmenu")
    public String saveMenu(SysMenu sysMenu){
        int i = sysMenuService.save(sysMenu);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            List<SysMenu> menus = sysMenuService.selectAll();
            json.put("menus",menus);
        }
        return json.toJSONString();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        int i = sysMenuService.deleteByPrimaryKey(id);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        return json.toJSONString();
    }
}
