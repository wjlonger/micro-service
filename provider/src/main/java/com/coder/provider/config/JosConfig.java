package com.coder.provider.config;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class JosConfig {

    public JosConfig(){}

    @Value("${jos.serverurl}")
    private  String serverUrl;

    @Value("${jos.accesstoken}")
    private String accessToken;

    @Value("${jos.appkey}")
    private String appKey ;

    @Value("${jos.appsecret}")
    private String appSecret;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Bean("jdClient")
    public JdClient jdClient(){
        return new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);
    }
}
