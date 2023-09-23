package com.atguigu.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * @Description: TODO 引入mybatis-plus的jar
 *                    引入mysql的驱动
 *                    配置mysql的数据源
 * @Author: qiaotao 
 * @Date: 2023/9/23 21:46
 */
@SpringBootApplication
@MapperScan("com.atguigu.gulimall.coupon.dao")
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
