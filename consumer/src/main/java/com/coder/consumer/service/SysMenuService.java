package com.coder.consumer.service;

import com.coder.consumer.component.SysMenuServiceHystric;
import com.coder.base.model.SysMenu;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="provider",fallback = SysMenuServiceHystric.class,path = "/sysmenu")
public interface SysMenuService {

    /**
     * RequestMapping("/selectall")
     * @return
     */
    @RequestLine("GET /selectall")
    List<SysMenu> selectAll();

}
