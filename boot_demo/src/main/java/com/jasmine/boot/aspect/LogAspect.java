package com.jasmine.boot.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.jasmine.boot.controller.AopController.*(..))")
    public  void LogAspect(){

    }

    @Before(value = "LogAspect()")
    public void before(JoinPoint joinPoint) {
        log.info("doBefore");
    }


    @Around(value = "LogAspect()")
    public Object around(ProceedingJoinPoint pjp) throws  Throwable{
        log.info("do around");
        return pjp.proceed();
    }

    @AfterReturning(value = "LogAspect()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("do after returning");
    }

    @AfterThrowing(value = "LogAspect()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("do after throwing");
    }

    @After(value = "LogAspect()")
    public void after(JoinPoint joinPoint) {
        log.info("do after");
    }
}