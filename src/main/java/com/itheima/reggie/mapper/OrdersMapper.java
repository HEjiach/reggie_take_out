package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2024-08-06 20:06:54
* @Entity com.itheima.reggie.entity.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}




