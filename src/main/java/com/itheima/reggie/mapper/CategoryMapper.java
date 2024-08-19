package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2024-08-06 20:06:25
* @Entity com.itheima.reggie.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




