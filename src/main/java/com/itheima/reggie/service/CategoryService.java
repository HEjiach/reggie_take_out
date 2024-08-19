package com.itheima.reggie.service;

import com.itheima.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何佳臣
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2024-08-06 20:06:25
*/
public interface CategoryService extends IService<Category> {
public void remove (Long id);
}
