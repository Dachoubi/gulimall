package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author qiaotao
 * @email 2294073149@qq.com
 * @date 2023-09-23 23:14:02
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
