package org.example.logging;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(public void org.example.services.userService.login())")
    public void loggingAdvice1(){
        System.out.println("Before login method");
    }


    @After("execution(public void org.example.services.userService.login())")
    public void loggingAdvice2(){
        System.out.println("After login method");
    }

    @Around("execution(public void org.example.services.userService.login())")
    public void loggingAdvice3(){
        System.out.println("Around login method");
    }
}
