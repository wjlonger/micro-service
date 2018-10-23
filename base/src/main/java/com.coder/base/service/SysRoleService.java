package com.coder.base.service;

import com.coder.base.model.SysMenu;
import com.coder.base.model.SysPermission;
import com.coder.base.model.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysRoleService {

//    int deleteByPrimaryKey(Integer rid);
//
//    int deleteByVo(SysRole sysRole);
//
//    int insert(SysRole sysRole);
//
//    int insertSelective(SysRole sysRole);
//
//    int insertToBatch(List<SysRole> sysRoles);
//
//    int updateByPrimaryKeySelective(SysRole sysRole);
//
//    int updateByPrimaryKey(SysRole sysRole);
//
//    int save(SysRole sysRole);
//
//    SysRole selectByPrimaryKey(Integer rid);

    List<SysRole> selectAll(SysRole sysRole);

//    PageInfo<SysRole> selectPage(int pageIndex, int pageSize, SysRole sysRole);
//
//    SysRole selectByProperty(SysRole sysRole);
//
//    int findCount(SysRole sysRole);
//
//    List<SysMenu> selectMenusByPrimaryKey(Integer id);
//
//    List<SysPermission> selectPermissionByPrimaryKey(Integer id);
//
//    List<SysMenu> selectOtherMenusByPrimaryKey(Integer id);
//
//    List<SysPermission> selectOtherPermissionByPrimaryKey(Integer id);
}
