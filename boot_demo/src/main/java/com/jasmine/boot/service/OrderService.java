package com.jasmine.boot.service;


        import com.jasmine.boot.pojo.Order;

public interface OrderService {

//    int addOrder(Order order);
    Order orderQuery(Integer orderId);
    String sendOrder(Integer orderId);
    Order queryOrderById(Integer id);
    String sendOrderByTransactionTemplate(Order order);
    String sendOrderByTransactionTemplate2(Order order);
}
