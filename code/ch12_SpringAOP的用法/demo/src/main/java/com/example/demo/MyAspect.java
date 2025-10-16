package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect 當為Bean 時才可以變成一個切面，所以通常使用 @Aspect 時，同時也需要使用 @Component，單純只在class加上 @Aspect 無法有效果
@Aspect
@Component
public class MyAspect {

    // @Before 後面的小括號中的程式，稱為「切入點(Pointcut)」
    // 在指定執行方法前設切入點
    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("I'm before");
    }
    
    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("I'm after");
    }
    
    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I'm around before");
        
        // 執行切入點的方法，obj 為切入點方法執行的結果
        Object obj = pjp.proceed();
        
        System.out.println("I'm around after");
        return obj;
    }
}
