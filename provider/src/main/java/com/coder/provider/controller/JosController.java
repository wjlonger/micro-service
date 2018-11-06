package com.coder.provider.controller;

import com.coder.base.service.JosService;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.cps.UnionThemeGoodsServiceQueryExplosiveGoodsRequest;
import com.jd.open.api.sdk.response.cps.UnionThemeGoodsServiceQueryExplosiveGoodsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jos")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class JosController {

    @Autowired
    private JosService josService;

    @GetMapping("/unionthemegoodsservicequeryexplosivegoods")
    public String UnionThemeGoodsServiceQueryExplosiveGoods(){
        return josService.UnionThemeGoodsServiceQueryExplosiveGoods();
    }

    public JosService getJosService() {
        return josService;
    }

    public void setJosService(JosService josService) {
        this.josService = josService;
    }

}
