package com.jasmine.boot.service.impl;


import com.jasmine.boot.mapper.OrderMapper;
import com.jasmine.boot.pojo.Order;
import com.jasmine.boot.service.InvokeService;
import com.jasmine.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements OrderService {
    private String url="http://localhost:8080/deliver?orderId=";
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    InvokeService invokeService;

    @Override
    public Order queryOrderById(Integer id) {
        return orderMapper.queryOrderById(id);
    }
    @Override
    public Order orderQuery(Integer orderId) {
        return orderMapper.queryOrderById(orderId);
    }

    /**
     * 声明式事务
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public String sendOrder(Integer orderId) {
        Order order = orderMapper.queryOrderById(orderId);
        String invoke = invokeService.invoke(url, orderId);
        order.setState(Integer.valueOf(invoke));
        orderMapper.updateOrder(order);
        return invoke;
    }

    /**
     * 编程式事务解决资源占用问题
     */

    @Autowired
    TransactionTemplate transactionTemplate;
    @Override
    public String sendOrderByTransactionTemplate(final  Order order){
        final Integer id = order.getId();
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Order order1 = new Order();
                order1.setId(id);
                order1.setState(2);
                orderMapper.updateOrder(order1);
                return null;
            }
        });
        String invoke = invokeService.invoke(url, id);
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Order order2 = new Order();
                order2.setId(id);
                order2.setState(Integer.valueOf(invoke));
                orderMapper.updateOrder(order2);
                return null;
            }
        });
        return invoke;
    }
    @Override
    public String sendOrderByTransactionTemplate2(final  Order order){
        final Integer id = order.getId();
        boolean flag= (boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Order order1 = new Order();
                order1.setId(id);
                order1.setState(2);
                order1.setVersion(order.getVersion());
               int s=orderMapper.updateOrderByVersion(order1);
                System.err.println(s);
                return s==1;
            }
        });
        String result="";
        if (flag){
            result = invokeService.invoke(url, id);
            transactionTemplate.execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus transactionStatus) {
                    transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
                    Order order2 = new Order();
                    order2.setId(id);
                    order2.setState(3);
                    orderMapper.updateOrder(order2);
                    return null;
                }
            });
            System.err.println("--------------调用成功------------");
        }else {
            System.err.println("--------------调用失败------------");
        }
        return result;
    }
}
