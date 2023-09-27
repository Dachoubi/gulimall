package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

/**
 * @ClassName GlobleCorsConfigration
 * @Description TODO
 * @Author qiaotao
 * @Date 2023/9/27 20:44
 */
@Configuration
public class GlobleCorsConfigration {

    /**
     * @Description: TODO 跨域配置,可以从前端的8081端口,访问网关的12001端口
     * @Author: qiaotao
     * @Date: 2023/9/27 20:55
     */
    @Bean
    public CorsWebFilter corsWebFilter(){

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*"); //允许的请求路径
        corsConfiguration.addAllowedMethod("*"); //允许的请求方式
        corsConfiguration.addAllowedHeader("*"); //允许的请求头
        corsConfiguration.setAllowCredentials(true); //是否允许cookie进行跨域

        //任意路径都进行跨域配置
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }
}
