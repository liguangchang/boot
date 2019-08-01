package com.jasmine.boot.controller;

import com.jasmine.boot.pojo.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author guangchang
 **/
@Controller
public class ThymeleafController {

    @GetMapping("/test")
    public String testThymeleaf(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "jasmine") String name, Model model) {
        request.setAttribute("name", name);
        request.setAttribute("key", "keyValue");
        request.setAttribute("input", "inputYourName");
        request.setAttribute("text", " th:text 输出文本");
        request.setAttribute("date", new Date());
        request.setAttribute("sex1", '男');
        request.setAttribute("sex2", '女');
        request.setAttribute("id1", 1);
        model.addAttribute("id2",2);
        List<Test> list = new ArrayList<>();
        list.add(new Test("jasmine",25));
        list.add(new Test("aladdin",26));
        list.add(new Test("boss",24));
        model.addAttribute("test",list);
        List<Test> collect = list.stream().sorted(Comparator.comparing(Test::getAge).reversed()).collect(Collectors.toList());
        model.addAttribute("collection",collect);
        return "testThymeleaf";
    }
}
