package com.coder.provider.controller;

import com.coder.base.service.SysMenuService;
import com.coder.base.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @DeleteMapping("/deleteByPrimaryKey/{id}")
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        return sysMenuService.deleteByPrimaryKey(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody SysMenu sysMenu) {
        return sysMenuService.save(sysMenu);
    }

    @GetMapping("/selectByPrimaryKey/{id}")
    public SysMenu selectByPrimaryKey(@PathVariable("id") Integer id) {
        return sysMenuService.selectByPrimaryKey(id);
    }

    @GetMapping("/selectAll")
    public List<SysMenu> selectAll() {
        return sysMenuService.selectAll();
    }

//    public int deleteByProperty(SysMenu sysMenu) {
//        return sysMenuService.deleteByProperty(sysMenu);
//    }
//
//    public int insert(SysMenu sysMenu) {
//        return sysMenuService.insert(sysMenu);
//    }
//
//    public int insertSelective(SysMenu sysMenu) {
//        return sysMenuService.insertSelective(sysMenu);
//    }
//
//    public int insertToBatch(List<SysMenu> sysMenus) {
//        return sysMenuService.insertToBatch(sysMenus);
//    }
//
//    public int updateByPrimaryKeySelective(SysMenu sysMenu) {
//        return sysMenuService.updateByPrimaryKeySelective(sysMenu);
//    }

//    public int updateByPrimaryKey(SysMenu sysMenu) {
//        return sysMenuService.updateByPrimaryKey(sysMenu);
//    }

//    public PageInfo<SysMenu> selectPage(int pageIndex, int pageSize) {
//        return sysMenuService.selectPage(pageIndex,pageSize);
//    }

//    public int findCount(SysMenu sysMenu) {
//        return sysMenuService.findCount(sysMenu);
//    }
}
