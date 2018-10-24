package com.coder.consumer.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.coder.base.model.RoleMenu;
import com.coder.base.model.RolePermission;
import com.coder.base.model.SysRole;
import com.coder.consumer.service.RoleMenuService;
import com.coder.consumer.service.RolePermissionService;
import com.coder.consumer.service.SysRoleService;
import com.coder.consumer.util.JsonUtils;
import com.coder.util.CollectionUtils;
import com.coder.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/api/role")
public class SystemRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping("/menu")
    public String saveMenu(@RequestBody RoleMenu roleMenu){
        int i = roleMenuService.insert(roleMenu);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            SysRole sysRole = sysRoleService.selectByPrimaryKey(roleMenu.getRoleid());
            json.put("role",sysRole);
        }
        return json.toString();
    }

    @PostMapping("/permission")
    public String savePermission(@RequestBody RolePermission rolePermission){
        int i = rolePermissionService.insert(rolePermission);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            SysRole sysRole = sysRoleService.selectByPrimaryKey(rolePermission.getRid());
            json.put("role",sysRole);
        }
        return json.toString();
    }

    @DeleteMapping("/menu/{roleid}/{menuid}")
    public String deleteMenu(@PathVariable("roleid") int roleid, @PathVariable("menuid") int menuid){
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleid(roleid);
        roleMenu.setMenuid(menuid);
        int i = roleMenuService.deleteByPrimaryKey(roleMenu);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            SysRole sysRole = sysRoleService.selectByPrimaryKey(roleMenu.getRoleid());
            json.put("role",sysRole);
        }
        return json.toString();
    }

    @DeleteMapping("/permission/{roleid}/{permissionid}")
    public String deletePermission(@PathVariable("roleid") int roleid, @PathVariable("permissionid") int permissionid){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRid(roleid);
        rolePermission.setPid(permissionid);
        int i = rolePermissionService.deleteByPrimaryKey(rolePermission);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        if(i > 0){
            SysRole sysRole = sysRoleService.selectByPrimaryKey(rolePermission.getRid());
            json.put("role",sysRole);
        }
        return json.toString();
    }

    @PostMapping
    public String save(SysRole sysRole,String[] mids, String[] pids){
        SysRole that = sysRoleService.save(sysRole);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(that.getRid(),json);
        if(that.getRid() > 0){
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleid(that.getRid());
            roleMenuService.deleteByProperty(roleMenu);
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRid(that.getRid());
            rolePermissionService.deleteByProperty(rolePermission);
            if(!CollectionUtils.isNullOrEmptyStrict(mids)){
                for(String mid : mids){
                    if(!StringUtils.isNullOrSpace(mid)){
                        int imid = Integer.parseInt(mid);
                        if(imid > 0){
                            RoleMenu rm = new RoleMenu();
                            rm.setRoleid(that.getRid());
                            rm.setMenuid(imid);
                            roleMenuService.insert(rm);
                        }
                    }
                }
            }
            if(!CollectionUtils.isNullOrEmptyStrict(pids)){
                for(String pid : pids){
                    if(!StringUtils.isNullOrSpace(pid)){
                        int ipid = Integer.parseInt(pid);
                        if(ipid > 0){
                            RolePermission rp = new RolePermission();
                            rp.setRid(that.getRid());
                            rp.setPid(ipid);
                            rolePermissionService.insert(rp);
                        }
                    }
                }
            }
            that = sysRoleService.selectByPrimaryKey(that.getRid());
            json.put("role",that);
        }
        return json.toString();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int rid){
        int i = sysRoleService.deleteByPrimaryKey(rid);
        JSONObject json = new JSONObject();
        JsonUtils.addMessage(i,json);
        return json.toString();
    }
}
