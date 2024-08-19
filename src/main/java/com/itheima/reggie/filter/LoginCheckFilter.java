package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求：{}",requestURI);
        //urls：不要需要拦截的路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };
        //2.是否处理，检查登录状态
        boolean check = check(urls, requestURI);
        //3.不需要处理
        if (check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }
        //4.判断登录状态，已登录直接放行
        if (request.getSession().getAttribute("employee") !=null){
            log.info("用户已登录，id为: {}",request.getSession().getAttribute("employee"));
            Long empid =(Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empid);
            filterChain.doFilter(request,response);
            return;
        }
        //4.1判断登录状态，已登录直接放行移动端
        if (request.getSession().getAttribute("user") !=null){
            log.info("用户已登录，id为: {}",request.getSession().getAttribute("user"));
            Long userid =(Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userid);
            filterChain.doFilter(request,response);
            return;
        }
//5.未登录返回登录结果，通过输出流向客户端响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    //2里面的封装判断方法
    public boolean check(String[] urls, String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                return true;
            }
        }
        return false;
    }
}
