package com.jasmine.idempotent.controller;

import com.jasmine.idempotent.annotation.Idempotent;
import com.jasmine.idempotent.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 幂等测试
 *
 * @author guangchang
 * @create 2019-07-31 00:18
 **/
@RestController
@RequestMapping("/test")
public class IdempotentController {

    @Autowired
    TokenService tokenService;

    @GetMapping("/create")
    public String createToken(){
        return tokenService.createToken();
    }

    @Idempotent
    @PostMapping("/token")
    public String testIdempotent(){
        return tokenService.testIdempotent();
    }
}
