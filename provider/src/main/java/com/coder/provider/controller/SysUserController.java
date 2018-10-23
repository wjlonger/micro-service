package com.coder.provider.controller;

import com.coder.base.service.SysUserService;
import com.coder.base.model.SysMenu;
import com.coder.base.model.SysRole;
import com.coder.base.model.SysUser;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/selectByPrimaryKey")
    public SysUser selectByPrimaryKey(@RequestParam("id") Integer id) {
        return sysUserService.selectByPrimaryKey(id);
    }

    public List<SysUser> selectAll(SysUser sysUser) {
        return sysUserService.selectAll(sysUser);
    }

    public PageInfo<SysUser> selectPage(int pageIndex, int pageSize, SysUser sysUser) {
        return sysUserService.selectPage(pageIndex, pageSize, sysUser);
    }

    @PostMapping("/selectbyproperty")
    public SysUser selectByProperty(@RequestBody SysUser sysUser) {
        return sysUserService.selectByProperty(sysUser);
    }

    public int deleteByPrimaryKey(Integer id) {
        return sysUserService.deleteByPrimaryKey(id);
    }

    public int deleteByVo(SysUser sysUser) {
        return sysUserService.deleteByVo(sysUser);
    }

    public int insert(SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }

    public int insertSelective(SysUser sysUser) {
        return sysUserService.insertSelective(sysUser);
    }

    public int insertToBatch(List<SysUser> sysUsers) {
        return sysUserService.insertToBatch(sysUsers);
    }

    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserService.updateByPrimaryKeySelective(sysUser);
    }

    public int updateByPrimaryKey(SysUser sysUser) {
        return sysUserService.updateByPrimaryKey(sysUser);
    }

    /**
     * 该方法默认按照主键去查，
     * 如果查得到则更新
     * 如果查不到则插入
     * 如果有其它业务需求，请自行编写业务代码
     * @param sysUser
     * @return
     */
    public int save(SysUser sysUser) {
        return sysUserService.save(sysUser);
    }

    public int findCount(SysUser sysUser) {
        return sysUserService.findCount(sysUser);
    }

    public List<SysRole> selectRoleByPrimaryKey(Integer id) {
        return sysUserService.selectRoleByPrimaryKey(id);
    }

    public List<SysMenu> selectMenuByPrimaryKey(Integer id) {
        return sysUserService.selectMenuByPrimaryKey(id);
    }
}
