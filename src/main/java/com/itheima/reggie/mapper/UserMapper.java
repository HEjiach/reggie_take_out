package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2024-08-06 20:07:06
* @Entity com.itheima.reggie.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




