package com.jasmine.boot.service.impl;


import com.jasmine.boot.mapper.UsersMapper;
import com.jasmine.boot.pojo.Users;
import com.jasmine.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author guangchang
 **/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUsers(users);
    }
}
