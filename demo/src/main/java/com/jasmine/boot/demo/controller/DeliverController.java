package com.jasmine.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class DeliverController {
   @RequestMapping("/deliver")
    public String delver(String orderId) {
       System.err.println("模拟接收到订单开始发货订单编号："+orderId);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            return "-1";
        }
        return "1";
    }
}
