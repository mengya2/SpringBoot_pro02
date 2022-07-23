package com.zww.config;

import com.zww.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

/**
 * 这个类用来进行注册Service的处理
 */
@Configuration
public class SystemConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        // ServletRegistrationBean()两个参数的
        ServletRegistrationBean reg = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return reg;
    }
}
