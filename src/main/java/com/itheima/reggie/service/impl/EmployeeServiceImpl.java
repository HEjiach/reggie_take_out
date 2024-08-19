package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;
import com.itheima.reggie.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author 何佳臣
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2024-08-06 20:06:48
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




