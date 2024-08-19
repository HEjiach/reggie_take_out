package com.itheima.reggie.mapper;

import com.itheima.reggie.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 何佳臣
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2024-08-06 20:06:48
* @Entity com.itheima.reggie.entity.Employee
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}




