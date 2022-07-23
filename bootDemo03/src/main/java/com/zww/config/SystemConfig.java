package com.zww.config;

import com.zww.servlet.MyFliter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class SystemConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean reg = new FilterRegistrationBean();
        // 使用过滤器
        reg.setFilter(new MyFliter());
        // 设置过滤器的地址
        reg.addUrlPatterns("/user/*");
        return reg;
    }
}
