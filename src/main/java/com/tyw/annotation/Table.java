package com.tyw.annotation;
/*
* @Description :
* @Date : 2018/8/14  9:54  
* */

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Table {

    String value() default "";

}
