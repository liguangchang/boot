package com.jasmine.boot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * boot 整合filter
 * @author guangchang
 * @create 2019-07-29 22:38
 **/
@Slf4j
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter running");
        log.error("doFilter before");
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
        log.error("doFilter after");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("myFilter init");
    }

    @Override
    public void destroy() {
        log.info("myFilter out");
    }
}
