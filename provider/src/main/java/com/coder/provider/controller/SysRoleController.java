package com.coder.provider.controller;

import com.coder.base.service.SysRoleService;
import com.coder.base.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/sysrole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/selectAll")
    public List<SysRole> selectAll(@RequestBody SysRole sysRole) {
        return sysRoleService.selectAll(sysRole);
    }

    @GetMapping("/selectByPrimaryKey/{id}")
    public SysRole selectByPrimaryKey(@PathVariable("id") Integer rid) {
        return sysRoleService.selectByPrimaryKey(rid);
    }

    @PostMapping("/save")
    public int save(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole);
    }

//    public int deleteByPrimaryKey(Integer rid) {
//        return sysRoleService.deleteByPrimaryKey(rid);
//    }
//
//    public int deleteByVo(SysRole sysRole) {
//        return sysRoleService.deleteByVo(sysRole);
//    }
//
//    public int insert(SysRole sysRole) {
//        return sysRoleService.insert(sysRole);
//    }
//
//    public int insertSelective(SysRole sysRole) {
//        return sysRoleService.insertSelective(sysRole);
//    }
//
//    public int insertToBatch(List<SysRole> sysRoles) {
//        return sysRoleService.insertToBatch(sysRoles);
//    }
//
//    public int updateByPrimaryKeySelective(SysRole sysRole) {
//        return sysRoleService.updateByPrimaryKeySelective(sysRole);
//    }
//
//    public int updateByPrimaryKey(SysRole sysRole) {
//        return sysRoleService.updateByPrimaryKey(sysRole);
//    }
//
//    public PageInfo<SysRole> selectPage(int pageIndex, int pageSize, SysRole sysRole) {
//        return sysRoleService.selectPage(pageIndex, pageSize, sysRole);
//    }
//
//    public SysRole selectByProperty(SysRole sysRole) {
//        return sysRoleService.selectByProperty(sysRole);
//    }
//
//    public int findCount(SysRole sysRole) {
//        return sysRoleService.findCount(sysRole);
//    }
//
//    public List<SysMenu> selectMenusByPrimaryKey(Integer id) {
//        return sysRoleService.selectMenusByPrimaryKey(id);
//    }
//
//    public List<SysPermission> selectPermissionByPrimaryKey(Integer id) {
//        return sysRoleService.selectPermissionByPrimaryKey(id);
//    }
//
//    public List<SysMenu> selectOtherMenusByPrimaryKey(Integer id) {
//        return sysRoleService.selectOtherMenusByPrimaryKey(id);
//    }
//
//    public List<SysPermission> selectOtherPermissionByPrimaryKey(Integer id) {
//        return sysRoleService.selectOtherPermissionByPrimaryKey(id);
//    }
}
