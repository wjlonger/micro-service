package com.coder.consumer.component;

import com.coder.base.model.RoleMenu;
import com.coder.consumer.service.RoleMenuService;
import feign.Param;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleMenuServiceHystric implements RoleMenuService {

    @Override
    public int deleteByPrimaryKey(RoleMenu roleMenu) {
        return 0;
    }

    @Override
    public int deleteByProperty(RoleMenu roleMenu) {
        return 0;
    }

    @Override
    public int insert(RoleMenu roleMenu) {
        return 0;
    }
}
