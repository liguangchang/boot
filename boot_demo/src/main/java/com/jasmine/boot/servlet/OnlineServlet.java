package com.jasmine.boot.servlet;

import com.jasmine.boot.listener.OnLineListener;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * boot整合servlet
 * @author guangchang
 * @create 2019-07-29 21:17
 **/
@Slf4j
@WebServlet(name="onlineServlet",urlPatterns="/online")
public class OnlineServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.println("当前在线人数："+req.getSession().getAttribute("online"));
        writer.println("当前在线人数："+OnLineListener.online);
        log.info("online:"+OnLineListener.online);
        log.info("session :"+req.getSession().getAttribute("online"));
        writer.flush();
        writer.close();
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        log("myServlet service");

    }

    @Override
    public void destroy() {
        super.destroy();
        log("myServlet destroy");
        log.info("myServlet out");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        log("myServlet init");
    }
}
