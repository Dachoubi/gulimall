package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** 
 * @Description: TODO 引入mybatis-plus的jar
 *                    引入mysql的驱动
 *                    配置mysql的数据源
 * @Author: qiaotao 
 * @Date: 2023/9/23 21:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.atguigu.gulimall.product.feign")
@MapperScan("com.atguigu.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
