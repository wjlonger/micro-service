package com.coder.base.service;

import com.coder.base.model.SysPermission;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysPermissionService {

    SysPermission selectByPrimaryKey(Integer id);

    PageInfo<SysPermission> selectPage(int pageIndex, int pageSize, SysPermission sysPermission);

    List<SysPermission> selectAll(SysPermission sysPermission);

    SysPermission selectByProperty(SysPermission sysPermission);

    int deleteByPrimaryKey(Integer id);

    int deleteByProperty(SysPermission sysPermission);

    int insert(SysPermission sysPermission);

    int insertSelective(SysPermission sysPermission);

    int insertToBatch(List<SysPermission> sysPermissions);

    int updateByPrimaryKeySelective(SysPermission sysPermission);

    int updateByPrimaryKey(SysPermission sysPermission);

    int save(SysPermission sysPermission);

    int findCount(SysPermission sysPermission);
}
