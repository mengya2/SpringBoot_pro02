package com.zww.regg.filter;


import com.alibaba.fastjson.JSON;
import com.zww.regg.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录的过滤器
* *    1、获取本次请求的URL
* *    2、判断本次请求是否需要处理
* *    3、不要要则，直接放行
* *    4、判断登录状态，要是已经登录，则放行
* *    5、要是没登录，则返回未登录状态
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    // String 中的路径匹配处理用的
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 1、获取本次请求的URL
        String requestURI = request.getRequestURI();
        // 不要处理的路径
        String[] urls = new String[]{
                "/employee/login","employee/logout","/backend/**","/front/**"
        };
        // 2、判断请求是否要处理,匹配到了就是true
        boolean check = check(urls,requestURI);

        //3、不需要处理，则放行
        if (check){
            filterChain.doFilter(request,response);
            return;
        }
        // 4、判断登录状态
        if (request.getSession().getAttribute("employee")!= null){
            filterChain.doFilter(request,response);
            return;
        }
        // 5、没登录，返回登录处理，向客户端响应json数据，前端收到JSON数据在进行处理
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }


    // URI比较处理的方法
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                return true;
            }
        }
        return false;
    }
}
