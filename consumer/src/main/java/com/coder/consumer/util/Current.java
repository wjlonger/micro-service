package com.coder.consumer.util;

import com.coder.base.model.SysMenu;
import com.coder.base.model.SysUser;
import org.apache.shiro.SecurityUtils;

import java.util.List;


/**
 * 当前登录人信息
 */
public final class Current {

    public static String siessionId(){
        return SecurityUtils.getSubject().getSession().getId().toString();
    }

    public static SysUser user(){
        try {
            return (SysUser) SecurityUtils.getSubject().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }

    public static List<SysMenu> menus(){
        return user() == null ? null : user().getMenuList();
    }
}
