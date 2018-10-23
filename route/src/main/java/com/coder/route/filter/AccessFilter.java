package com.coder.route.filter;

import javax.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter  extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s demoFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        // 获取请求的参数
        String username = request.getParameter("username");
        //通过
        if(!StringUtils.isEmpty(username)&&username.equals("lilei")){
            // 对该请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            // 设值，让下一个Filter看到上一个Filter的状态
            ctx.set("isSuccess", true);
            return null;
        }else{
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            // 返回错误码
            ctx.setResponseStatusCode(401);
            // 返回错误内容
            ctx.setResponseBody("{\"result\":\"username is not correct!\"}");
            ctx.set("isSuccess", false);
            return null;
        }
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return false;
    }
    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 0;
    }
    /**
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * */
    @Override
    public String filterType() {
        // 前置过滤器
        return "pre";
    }
}
