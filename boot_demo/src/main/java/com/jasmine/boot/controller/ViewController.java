package com.jasmine.boot.controller;

import com.jasmine.boot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * view controller
 *
 * @author guangchang
 * @create 2019-07-30 15:26
 **/
@Controller
public class ViewController {

    @RequestMapping("/showUser")
    public String showUser(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三", 20));
        list.add(new User(2, "李四", 22));
        list.add(new User(3, "王五", 24));
        // 需要一个 Model 对象
        model.addAttribute("list", list);
        // 跳转视图
        return "userList";
    }

//    @RequestMapping("/thymeleaf")
//    public String testThymeleaf(){
//        return "TestThymeleaf";
//    }
}
