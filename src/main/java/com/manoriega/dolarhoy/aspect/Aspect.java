package com.manoriega.dolarhoy.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@org.aspectj.lang.annotation.Aspect
@Component
@Log4j2
public class Aspect {

    @Pointcut("execution(String com.manoriega.dolarhoy.service.DolarService.text (..))")
    public void metodosPaquete(){

    }

    @After("metodosPaquete())")
    public void foo() {
        System.out.println("foo()" + LocalDateTime.now());
    }

//    generic exception
}
