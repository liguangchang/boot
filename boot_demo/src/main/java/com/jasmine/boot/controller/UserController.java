package com.jasmine.boot.controller;

import com.jasmine.boot.pojo.Users;
import com.jasmine.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users) {
        System.err.println(this);
        this.usersService.addUser(users);
        return "ok";
    }
}
