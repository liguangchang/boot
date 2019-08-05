package com.jasmine.boot.dubbo.service;

import com.jasmine.boot.dubbo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    Map<String, Object> addMethod();
}
