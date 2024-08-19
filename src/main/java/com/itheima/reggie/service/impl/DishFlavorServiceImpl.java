package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author 何佳臣
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2024-08-06 20:06:45
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




