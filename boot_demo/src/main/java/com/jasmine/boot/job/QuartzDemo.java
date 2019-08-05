package com.jasmine.boot.job;

import com.jasmine.boot.pojo.Users;
import com.jasmine.boot.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class QuartzDemo implements Job {

    @Autowired
    UsersService usersService;

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("quartz Execute...."+new Date());
        usersService.addUser(new Users(6,"ds",3));
    }
}
