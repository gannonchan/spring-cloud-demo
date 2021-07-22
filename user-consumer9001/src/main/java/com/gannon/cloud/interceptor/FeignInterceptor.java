package com.gannon.cloud.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("auth","123456");
        requestTemplate.query("name","gannon");
        requestTemplate.uri("/1");
    }
}
