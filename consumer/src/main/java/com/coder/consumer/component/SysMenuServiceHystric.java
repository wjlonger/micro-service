package com.coder.consumer.component;

import com.coder.consumer.service.SysMenuService;
import com.coder.base.model.SysMenu;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SysMenuServiceHystric implements SysMenuService {

    @Override
    public List<SysMenu> selectAll() {
        return null;
    }

    @Override
    public int save(SysMenu sysMenu) {
        return 0;
    }

    @Override
    public SysMenu selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }
}
