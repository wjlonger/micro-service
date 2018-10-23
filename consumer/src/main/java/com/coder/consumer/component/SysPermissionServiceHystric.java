package com.coder.consumer.component;

import com.coder.base.model.SysPermission;
import com.coder.consumer.service.SysPermissionService;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SysPermissionServiceHystric implements SysPermissionService {

    @Override
    public List<SysPermission> selectAll(SysPermission sysPermission) {
        return null;
    }
}
