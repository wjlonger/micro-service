package com.coder.consumer.component;

import com.coder.consumer.service.SysUserService;
import com.coder.base.model.SysUser;
import org.springframework.context.annotation.Configuration;

/**
 * @author buzai
 */
@Configuration
public class SysUserServiceHystric implements SysUserService {

    @Override
    public SysUser selectByProperty(SysUser sysUser) {
        return null;
    }
}
