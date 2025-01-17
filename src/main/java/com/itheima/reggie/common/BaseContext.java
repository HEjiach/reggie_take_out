package com.itheima.reggie.common;

/**
 * 基于ThreadLocal封装工具类，用于获取当前用于的登录id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal =new ThreadLocal<>();
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
