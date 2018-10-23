package com.coder.provider.mapper;

import com.coder.base.model.RolePermission;

public interface RolePermissionMapper {

    int deleteByPrimaryKey(RolePermission rolePermission);

    int deleteByProperty(RolePermission rolePermission);

    int insert(RolePermission rolePermission);

}