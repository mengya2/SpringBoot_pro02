package com.zww.config;

import com.zww.web.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象，自己创建的给写进去
        HandlerInterceptor interceptor = new LoginInterceptor();

        // 设置指定的拦截器url地址 ,表示user下面的都进行拦截处理
        String path[] = {"/user/**"};
        // 设置不进行拦截处理的地址
        String excludePath[] = {"/user/login"};
        registry.addInterceptor(interceptor).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
