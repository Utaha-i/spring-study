package com.utaha.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //声明注解作用在方法上面
@Retention(RetentionPolicy.RUNTIME) //注解保留至运行时
public @interface AopInter {
    String demo() default "我按了呀";
}