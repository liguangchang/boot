package com.jasmine.boot.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Spring 定时任务
 */
@Component
public class ScheduledDemo {

    @Scheduled(cron="0/2 * * * * ?")
    public void scheduledMethod(){
        System.out.println("定时器被触发"+new Date());
    }
}
