package com.jasmine.boot;

import com.jasmine.boot.mapper.OrderMapper;
import com.jasmine.boot.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){

        Order order = orderMapper.queryOrderById(1);
        System.err.println(order);

    }
    @Test
    public void test2(){
        int i = orderMapper.addOrder(new Order(4, 4, 4, 4));
        System.err.println(i);
    }



}
