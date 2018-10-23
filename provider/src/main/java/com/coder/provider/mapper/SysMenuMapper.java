package com.coder.provider.mapper;

import com.coder.base.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByProperty(SysMenu sysMenu);

    int insert(SysMenu sysMenu);

    int insertSelective(SysMenu sysMenu);

    int insertToBatch(List<SysMenu> sysMenus);

    int updateByPrimaryKeySelective(SysMenu sysMenu);

    int updateByPrimaryKey(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu> selectAll();

    int findCount(SysMenu sysMenu);
}