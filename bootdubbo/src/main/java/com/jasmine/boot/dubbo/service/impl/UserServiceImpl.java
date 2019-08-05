package com.jasmine.boot.dubbo.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.google.common.collect.Maps;
import com.jasmine.boot.dubbo.mapper.UserMapper;
import com.jasmine.boot.dubbo.pojo.User;
import com.jasmine.boot.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    /**
     * 增加调用方基本信息
     * @param id
     * @return
     */
    @Override
    public User selectByPrimaryKey(Long id) {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIp = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String url = RpcContext.getContext().getUrl().toFullString();

        log.info("{} {} {}", isProviderSide, clientIp, url);
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /**
     * 接口新增一个方法测试
     * @return
     */
    @Override
    public Map<String, Object> addMethod() {
        Map<String,Object> result = Maps.newHashMap();
        result.put("attachment", true);
        String count = RpcContext.getContext().getAttachment("count");
        result.put("count", count);
        return result;
    }
}
