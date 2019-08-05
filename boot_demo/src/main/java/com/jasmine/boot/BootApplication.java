package com.jasmine.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author guangchang
 * @create 2019-07-29 21:16
 **/
@SpringBootApplication
//@ServletComponentScan(basePackages = "com.jasmine.boot")
@MapperScan(basePackages = "com.jasmine.boot.mapper")
@EnableTransactionManagement
@EnableScheduling
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
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

