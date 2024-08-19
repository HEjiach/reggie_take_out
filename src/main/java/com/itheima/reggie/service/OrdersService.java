package com.itheima.reggie.service;

import com.itheima.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何佳臣
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2024-08-06 20:06:54
*/
public interface OrdersService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
