package com.example.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.book.controller.PeopleBookController.*(..))")
    public void allPoints() {
    }

    @Before("allPoints()")
    public void beforeCall(JoinPoint joinPoint) {
        System.out.println("////////////////////////////////////////////");

        System.out.println("Star method name: " + joinPoint.getSignature().getName() +
                " Time: " + LocalDate.now());
        System.out.println("////////////////////////////////////////////");

    }
}
