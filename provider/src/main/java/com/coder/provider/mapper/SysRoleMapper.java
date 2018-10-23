package com.coder.provider.mapper;

import com.coder.base.model.SysMenu;
import com.coder.base.model.SysPermission;
import com.coder.base.model.SysRole;

import java.util.List;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Integer rid);

    int deleteByProperty(SysRole sysRole);

    int insert(SysRole sysRole);

    int insertSelective(SysRole sysRole);

    int insertToBatch(List<SysRole> sysRoles);

    int updateByPrimaryKeySelective(SysRole sysRole);

    int updateByPrimaryKey(SysRole sysRole);

    SysRole selectByPrimaryKey(Integer rid);

    List<SysRole> selectByVo(SysRole sysRole);

    SysRole selectByProperty(SysRole sysRole);

    int findCount(SysRole sysRole);

    List<SysMenu> selectMenusByPrimaryKey(Integer id);

    List<SysPermission> selectPermissionByPrimaryKey(Integer id);

    List<SysMenu> selectOtherMenusByPrimaryKey(Integer id);

    List<SysPermission> selectOtherPermissionByPrimaryKey(Integer id);

}