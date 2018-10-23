package com.coder.provider.serviceimpl;

import com.coder.base.model.RoleMenu;
import com.coder.base.service.RoleMenuService;
import com.coder.provider.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public int deleteByPrimaryKey(RoleMenu roleMenu) {
        return roleMenuMapper.deleteByPrimaryKey(roleMenu);
    }

    @Override
    public int deleteByProperty(RoleMenu roleMenu) {
        return roleMenuMapper.deleteByProperty(roleMenu);
    }

    @Override
    public int insert(RoleMenu roleMenu) {
        return roleMenuMapper.insert(roleMenu);
    }
}
