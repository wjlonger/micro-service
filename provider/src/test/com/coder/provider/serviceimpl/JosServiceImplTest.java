package com.coder.provider.serviceimpl;

import com.coder.base.service.JosService;
import com.coder.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JosServiceImplTest {

    @Autowired
    private JosService josService;

    @Test
    public void testUnionThemeGoodsServiceQueryExplosiveGoods(){
        String s = josService.UnionThemeGoodsServiceQueryExplosiveGoods();
        if(!StringUtils.isNullOrEmpty(s)){
            System.out.println(s);
        }
    }

    @Test
    public void testServicePromotionGoodsInfo(){
        String s = josService.ServicePromotionGoodsInfo();
        if(!StringUtils.isNullOrEmpty(s)){
            System.out.println(s);
        }
    }

    public JosService getJosService() {
        return josService;
    }

    public void setJosService(JosService josService) {
        this.josService = josService;
    }
}
