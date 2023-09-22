package com.atguigu.gulimall.common.dao;

import com.atguigu.gulimall.common.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author qiaotao
 * @email 2294073149@qq.com
 * @date 2023-09-22 23:21:12
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
