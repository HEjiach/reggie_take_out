package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
* @createDate 2024-08-06 20:06:51
* @Entity com.itheima.reggie.entity.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}




