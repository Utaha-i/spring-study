package com.utaha.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationPointCut {
    //配置PointCut
    @Pointcut("execution(* com.utaha.service.impl.UserServiceImpl.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("注解实现*********前********");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("注解实现*********后********");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        jp.proceed();//执行方法
        Signature signature = jp.getSignature();//获得签名
        System.out.println("signature:" + signature);
        System.out.println("环绕后");
    }
}
