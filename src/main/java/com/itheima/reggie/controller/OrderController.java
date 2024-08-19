package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.OrderDto;
import com.itheima.reggie.entity.OrderDetail;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.service.OrderDetailService;
import com.itheima.reggie.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailService orderDetailService;
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        ordersService.submit(orders);
        return R.success("下单成功!");

    }
    @GetMapping("/userPage")
    public R<Page>page(int page,int pageSize){
        //获取当前id
        Long userId = BaseContext.getCurrentId();
        Page<Orders> pageInfo=new Page<>(page,pageSize);
        Page<OrderDto> orderDtoPage=new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
        //查询当前用户id订单数据
        queryWrapper.eq(userId!=null,Orders::getUserId,userId);
        //按时间降序排序
        queryWrapper.orderByDesc(Orders::getOrderTime);
        ordersService.page(pageInfo,queryWrapper);
        List<OrderDto> list=pageInfo.getRecords().stream().map((item)->{
            OrderDto orderDto=new OrderDto();
            //获取orderiD，然后根据这哥id查orderDetail表中的数据
            Long orderId = item.getId();
            LambdaQueryWrapper<OrderDetail> wrapper=new LambdaQueryWrapper<>();
            wrapper.eq(OrderDetail::getOrderId,orderId);
            List<OrderDetail> details = orderDetailService.list(wrapper);
            BeanUtils.copyProperties(item,orderDto);
            orderDto.setOrderDetails(details);
            return orderDto;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(pageInfo,orderDtoPage,"records");
        orderDtoPage.setRecords(list);
        log.info("list:{}",list);
        return R.success(orderDtoPage);
    }
}
