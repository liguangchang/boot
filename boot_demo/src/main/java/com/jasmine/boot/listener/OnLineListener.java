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

    /**
     * 网站人数统计
     */
    public static int online=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       log.error("online ++");
       online++;
       se.getSession().setAttribute("online",online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.error("online--");
        online--;
        se.getSession().setAttribute("online",online);
    }
}
