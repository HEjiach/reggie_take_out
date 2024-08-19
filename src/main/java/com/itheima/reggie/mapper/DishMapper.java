package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2024-08-06 20:06:41
* @Entity com.itheima.reggie.entity.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}




