package com.example.customeraspectlog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.customeraspectlog.controller.CustomerController.*(..))")
    public void allPointcut(){
    }

    @Before("allPointcut()")
    public void beforeCall(JoinPoint joinPoint){
        System.out.println("Star method name: "+ joinPoint.getSignature().getName()+
                " Time: "+ LocalDate.now());
    }
}
