package com.itheima.reggie.service;

import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何佳臣
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2024-08-06 20:06:41
*/
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish，dishflavor
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavour(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
