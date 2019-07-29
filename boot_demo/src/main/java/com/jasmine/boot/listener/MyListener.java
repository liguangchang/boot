package com.jasmine.boot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * boot整合listener
 *
 * @author guangchang
 * @create 2019-07-29 22:56
 **/
@WebListener
@Slf4j
public class MyListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
      log.error("myListener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    log.error("myListener destroy");
    }
}
