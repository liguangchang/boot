package com.jasmine.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * thymeleaf
 *
 * @author guangchang
 * @create 2019-07-29 18:09
 **/
@RestController
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String testThymeleaf(){
        return "TestThymeleaf";
    }
}
