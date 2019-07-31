package com.jasmine.boot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听session统计网站人数
 * @author guangchang
 * @create 2019-07-29 23:02
 **/
@Slf4j
@WebListener
public class OnLineListener implements HttpSessionListener {
    public static int online;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        online++;
        log.info("session创建。。。");
        se.getSession().setAttribute("online", online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
        log.info("session销毁。。。");
        se.getSession().setAttribute("online", online);
    }

}
