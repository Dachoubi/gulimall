package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author qiaotao
 * @email 2294073149@qq.com
 * @date 2023-09-22 23:17:06
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
