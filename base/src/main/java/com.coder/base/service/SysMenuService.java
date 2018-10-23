package com.coder.base.service;

import com.coder.base.model.SysMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysMenuService {

    int deleteByPrimaryKey(Integer id);

//    int deleteByProperty(SysMenu sysMenu);
//
//    int insert(SysMenu sysMenu);
//
//    int insertSelective(SysMenu sysMenu);
//
//    int insertToBatch(List<SysMenu> sysMenus);
//
//    int updateByPrimaryKeySelective(SysMenu sysMenu);
//
//    int updateByPrimaryKey(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu> selectAll();

//    PageInfo<SysMenu> selectPage(int pageIndex, int pageSize);

    int save(SysMenu sysMenu);

//    int findCount(SysMenu sysMenu);
}
