package com.coder.consumer.component;

import com.coder.base.model.SysRole;
import com.coder.consumer.service.SysRoleService;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SysRoleServiceHystric implements SysRoleService {

    @Override
    public SysRole selectByPrimaryKey(Integer rid) {
        return null;
    }

    @Override
    public int save(SysRole sysRole) {
        return 0;
    }

    @Override
    public List<SysRole> selectAll(SysRole sysRole) {
        return null;
    }
}
