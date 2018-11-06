package com.coder.provider.serviceimpl;

import com.coder.base.service.JosService;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.cps.ServicePromotionGoodsInfoRequest;
import com.jd.open.api.sdk.request.cps.UnionThemeGoodsServiceQueryExplosiveGoodsRequest;
import com.jd.open.api.sdk.response.cps.ServicePromotionGoodsInfoResponse;
import com.jd.open.api.sdk.response.cps.UnionThemeGoodsServiceQueryExplosiveGoodsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("josService")
public class JosServiceImpl implements JosService {

    @Autowired
    private JdClient client;

    @Override
    public String UnionThemeGoodsServiceQueryExplosiveGoods(){
        UnionThemeGoodsServiceQueryExplosiveGoodsRequest request = new UnionThemeGoodsServiceQueryExplosiveGoodsRequest();
        request.setFrom( 1 );
        request.setPageSize( 10 );
        //request.setCid3( 123 );
        UnionThemeGoodsServiceQueryExplosiveGoodsResponse response = null;
        try {
            response = client.execute(request);
            return response.getQueryExplosiveGoodsResult();
        } catch (JdException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String ServicePromotionGoodsInfo() {
        //33728759312
        ServicePromotionGoodsInfoRequest request = new ServicePromotionGoodsInfoRequest();
        request.setSkuIds( "33728759312,31932526141" );
        try {
            ServicePromotionGoodsInfoResponse response=client.execute(request);
            return response.getGetpromotioninfoResult();
        } catch (JdException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JdClient getClient() {
        return client;
    }

    public void setClient(JdClient client) {
        this.client = client;
    }
}
