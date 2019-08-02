package com.jasmine.boot.controller;


import com.jasmine.boot.pojo.Order;
import com.jasmine.boot.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping("/query")
    public Order queryOrderById(Integer orderId){
        return orderService.orderQuery(orderId);
    }

    @RequestMapping("/send")
    public String sendOrder(Integer orderId){
        return orderService.sendOrder(orderId);
    }
    @RequestMapping("/sendOrderByTransaction")
    public String sendOrderByTransaction(Integer orderId){
        Order order = orderService.queryOrderById(orderId);
        String s = orderService.sendOrderByTransactionTemplate(order);
        return s;
    }
    @RequestMapping("/sendOrderByTransaction2")
    public String sendOrderByTransaction2(Integer orderId){
        Order order = orderService.queryOrderById(orderId);
        for (int i = 0; i < 10; i++) {
            new Thread(()->orderService.sendOrderByTransactionTemplate(order)).start();
        }
        return "xxx";
    }

    /**
     * 乐观锁
     * @param orderId
     * @return
     */
    @RequestMapping("/sendOrderByTransaction3")
    public String sendOrderByTransaction3(Integer orderId){
        Order order = orderService.queryOrderById(orderId);
        for (int i = 0; i < 10; i++) {
            new Thread(()->orderService.sendOrderByTransactionTemplate2(order)).start();
        }
        return "乐观锁";
    }
}
