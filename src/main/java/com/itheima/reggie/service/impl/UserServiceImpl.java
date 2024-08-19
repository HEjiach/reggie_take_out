package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 何佳臣
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2024-08-06 20:07:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




