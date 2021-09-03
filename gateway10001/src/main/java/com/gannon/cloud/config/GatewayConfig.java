package com.gannon.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    //使用配置类方式映射动态路由
    @Bean
    public RouteLocator newRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator routeLocator = routes.route("path_user_route",
                r -> r.path("/provider/users")
                        .uri("lb://cloud-user-provider/provider/users"))
                .build();
        return routeLocator;
    }
}
