package com.jasmine.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *
 * @author guangchang
 * @create 2019-07-29 21:16
 **/
@SpringBootApplication
@ServletComponentScan(basePackages = "com.jasmine.boot")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    /**
     * servlet
     */
//    @Bean
//    public ServletRegistrationBean getServletRegistrationBean(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet());
//        bean.addUrlMappings("/myServlet");
//        return bean;
//
//    }
    /**
     * filter
     */
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new MyFilter());
//        bean.addUrlPatterns("/filter");
//        return bean;
//    }
    /**
     * listener
     */
//    @Bean
//    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
//        ServletListenerRegistrationBean bean= new ServletListenerRegistrationBean(new MyListener());
//        return bean;
//    }
}

