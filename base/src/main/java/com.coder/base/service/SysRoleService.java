package com.coder.base.service;

import com.coder.base.model.SysRole;

import java.util.List;

public interface SysRoleService {

    SysRole selectByPrimaryKey(Integer rid);

    List<SysRole> selectAll(SysRole sysRole);

    SysRole save(SysRole sysRole);

    int deleteByPrimaryKey(Integer rid);

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
