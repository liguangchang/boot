package com.jasmine.boot.service.impl;


import com.jasmine.boot.service.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class InvokeServiceImpl implements InvokeService {

    @Autowired
    RestTemplate restTemplate;
    @Override
    public String invoke(String url, Integer orderId) {
        return restTemplate.getForEntity(url+orderId,String.class).getBody();
    }
}
