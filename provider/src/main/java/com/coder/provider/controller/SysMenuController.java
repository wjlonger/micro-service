package com.coder.provider.controller;

import com.coder.base.service.SysMenuService;
import com.coder.base.model.SysMenu;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    public int deleteByPrimaryKey(Integer id) {
        return sysMenuService.deleteByPrimaryKey(id);
    }

    public int deleteByProperty(SysMenu sysMenu) {
        return sysMenuService.deleteByProperty(sysMenu);
    }

    public int insert(SysMenu sysMenu) {
        return sysMenuService.insert(sysMenu);
    }

    public int insertSelective(SysMenu sysMenu) {
        return sysMenuService.insertSelective(sysMenu);
    }

    public int insertToBatch(List<SysMenu> sysMenus) {
        return sysMenuService.insertToBatch(sysMenus);
    }

    public int updateByPrimaryKeySelective(SysMenu sysMenu) {
        return sysMenuService.updateByPrimaryKeySelective(sysMenu);
    }

    public int updateByPrimaryKey(SysMenu sysMenu) {
        return sysMenuService.updateByPrimaryKey(sysMenu);
    }

    public SysMenu selectByPrimaryKey(Integer id) {
        return sysMenuService.selectByPrimaryKey(id);
    }

    @GetMapping("/selectall")
    public List<SysMenu> selectAll() {
        return sysMenuService.selectAll();
    }

    public PageInfo<SysMenu> selectPage(int pageIndex, int pageSize) {
        return sysMenuService.selectPage(pageIndex,pageSize);
    }

    public int save(SysMenu sysMenu) {
        return sysMenuService.save(sysMenu);
    }

    public int findCount(SysMenu sysMenu) {
        return sysMenuService.findCount(sysMenu);
    }
}
