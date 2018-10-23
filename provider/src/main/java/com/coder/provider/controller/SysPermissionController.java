package com.coder.provider.controller;

import com.coder.base.service.SysPermissionService;
import com.coder.base.model.SysPermission;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/syspermission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @PostMapping("/selectAll")
    public List<SysPermission> selectAll(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.selectAll(sysPermission);
    }

//    public SysPermission selectByPrimaryKey(Integer id) {
//        return sysPermissionService.selectByPrimaryKey(id);
//    }

//    public PageInfo<SysPermission> selectPage(int pageIndex, int pageSize, SysPermission sysPermission) {
//        return sysPermissionService.selectPage(pageIndex, pageSize, sysPermission);
//    }

//    public SysPermission selectByProperty(SysPermission sysPermission) {
//        return sysPermissionService.selectByProperty(sysPermission);
//    }

//    public int deleteByPrimaryKey(Integer id) {
//        return sysPermissionService.deleteByPrimaryKey(id);
//    }
//
//    public int deleteByProperty(SysPermission sysPermission) {
//        return sysPermissionService.deleteByProperty(sysPermission);
//    }
//
//    public int insert(SysPermission sysPermission) {
//        return sysPermissionService.insert(sysPermission);
//    }
//
//    public int insertSelective(SysPermission sysPermission) {
//        return sysPermissionService.insert(sysPermission);
//    }
//
//    public int insertToBatch(List<SysPermission> sysPermissions) {
//        return sysPermissionService.insertToBatch(sysPermissions);
//    }
//
//    public int updateByPrimaryKeySelective(SysPermission sysPermission) {
//        return sysPermissionService.updateByPrimaryKeySelective(sysPermission);
//    }
//
//    public int updateByPrimaryKey(SysPermission sysPermission) {
//        return sysPermissionService.updateByPrimaryKey(sysPermission);
//    }
//
//    public int save(SysPermission sysPermission) {
//        return sysPermissionService.save(sysPermission);
//    }
//
//    public int findCount(SysPermission sysPermission) {
//        return sysPermissionService.findCount(sysPermission);
//    }

}
