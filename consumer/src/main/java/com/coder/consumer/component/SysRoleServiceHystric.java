package com.coder.consumer.component;

import com.coder.base.model.SysRole;
import com.coder.consumer.service.SysRoleService;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SysRoleServiceHystric implements SysRoleService {

    @Override
    public List<SysRole> selectAll(SysRole sysRole) {
        return null;
    }
}
