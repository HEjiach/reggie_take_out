package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.AddressBook;
import com.itheima.reggie.service.AddressBookService;
import com.itheima.reggie.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 何佳臣
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2024-08-06 19:48:15
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




