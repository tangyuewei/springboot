package com.tyw.annotation;

import java.lang.annotation.*;

/*
* @Description :
* @Date : 2018/8/14  16:29  
* */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String value() default "*";
}
