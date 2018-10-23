package com.coder.base.service;

import com.coder.base.model.RolePermission;

public interface RolePermissionService {

    int deleteByPrimaryKey(RolePermission rolePermission);

    int deleteByProperty(RolePermission rolePermission);

    int insert(RolePermission rolePermission);

}
