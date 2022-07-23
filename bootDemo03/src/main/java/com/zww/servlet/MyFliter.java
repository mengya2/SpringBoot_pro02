package com.zww.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.nio.file.attribute.FileAttribute;
import java.util.logging.LogRecord;

public class MyFliter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("使用了MyFliter中的doFilter类，创建一个自己的过滤器");
    }
}
