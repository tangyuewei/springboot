package com.tyw.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by tboss on 2017/11/12.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.tyw.controller.UserController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void  before(){
        logger.info("before");
    }
    @After("log()")
    public void after(){
        logger.info("after");
    }
    @AfterReturning("log()")
    public void afterReturning(){logger.info("afterReturning");}
}
