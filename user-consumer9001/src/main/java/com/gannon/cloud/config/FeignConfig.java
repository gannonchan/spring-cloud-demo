package com.gannon.cloud.config;

import com.gannon.cloud.interceptor.FeignInterceptor;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    /**
     * 注入请求连接参数配置
     * @return
     */
    @Bean
    public Request.Options getRequestOptions(){
        //不手动配置超时则使用默认配置链接10秒读取60秒
        return new Request.Options(5L, TimeUnit.SECONDS, 60L, TimeUnit.SECONDS, true);
    }

    /**
     * 注入自定义feign拦截器
     * @return
     */
    @Bean
    public FeignInterceptor getFeignInterceptor(){
        return new FeignInterceptor();
    }
}
