package com.coder.base.service;

import com.coder.base.model.RoleMenu;

public interface RoleMenuService {

    int deleteByPrimaryKey(RoleMenu roleMenu);

    int deleteByProperty(RoleMenu roleMenu);

    int insert(RoleMenu roleMenu);
}
