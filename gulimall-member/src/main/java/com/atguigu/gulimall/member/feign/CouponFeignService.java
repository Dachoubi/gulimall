package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @InterfaceName CouponFeignService
 * @Description TODO
 * @Author qiaotao
 * @Date 2023/9/24 18:40
 */
@FeignClient("gulimall-coupon") //声明式的调用
public interface CouponFeignService {

    /** 
     * @Description: TODO 方法的全路径
     * @Author: qiaotao 
     * @Date: 2023/9/24 18:42
     */
    @RequestMapping("/coupon/coupon/coupon/list")
    public R couponList();

}
