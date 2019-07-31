package com.jasmine.idempotent.config;

import com.jasmine.idempotent.interceptor.IdempotentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author guangchang
 * @create 2019-07-31 12:13
 **/
@Configuration
public class InterceptorConfig  {
    @Autowired
    private IdempotentInterceptor idempotentInterceptor;
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(idempotentInterceptor).addPathPatterns("/**");
            }
        };
    }
}
