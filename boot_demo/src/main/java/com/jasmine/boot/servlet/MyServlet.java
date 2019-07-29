package com.jasmine.boot.servlet;

import com.jasmine.boot.listener.OnLineListener;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * boot整合servlet
 * @author guangchang
 * @create 2019-07-29 21:17
 **/
@WebServlet(name = "myServlet",urlPatterns = "/myServlet")
@Slf4j
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().append("myServlet doGet");
        resp.getWriter().append((char) OnLineListener.online);
        log.error(String.valueOf(OnLineListener.online));
        Integer online = (Integer) req.getSession().getAttribute("online");
        log.error(online.toString());
        log("doGet over");
        resp.getWriter().append("在线人数："+online);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
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
