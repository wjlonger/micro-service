package com.coder.provider.mapper;

import com.coder.base.model.RoleMenu;

public interface RoleMenuMapper {

    int deleteByPrimaryKey(RoleMenu roleMenu);

    int deleteByProperty(RoleMenu roleMenu);

    int insert(RoleMenu roleMenu);

}