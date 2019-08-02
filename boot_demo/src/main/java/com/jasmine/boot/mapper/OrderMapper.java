package com.jasmine.boot.mapper;


import com.jasmine.boot.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {

    @Insert("insert into `order`values (#{id},#{money},#{state},#{version})")
    int addOrder(Order order);
    @Select("select * from `order` where id=#{id}")
    Order queryOrderById(Integer orderId);
//    @Update("update order set state='1' where id=#{orderId}")
//    String sendOrder(String orderId);
    @Update("update `order` set state=#{state} where id=#{id}")
    void updateOrder(Order order);

    @Update("update `order` set state=#{state},version=version+1 where id=#{id} and version=#{version}")
    Integer updateOrderByVersion(Order order);
}
