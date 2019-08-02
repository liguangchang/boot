package com.jasmine.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class AopController {

    @RequestMapping("/aop")
    public String testAop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.error("aop Controller test aop");
        return "aop";
    }
}
