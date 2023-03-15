package com.utaha.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
@Slf4j
public class LogAspect {


/*
    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "execution(public int com.utaha.service.Calculator.add(int,int))")
    public void printLogBeforeCore() {
        log.debug("[AOP前置通知] 方法开始了");
    }

    @AfterReturning(value = "execution(public int com.utaha.service.Calculator.add(int,int))")
    public void printLogAfterSuccess() {
        log.debug("[AOP返回通知] 方法成功返回了");
    }

    @AfterThrowing(value = "execution(public int com.utaha.service.Calculator.add(int,int))")
    public void printLogAfterException() {
        log.debug("[AOP异常通知] 方法抛异常了");
    }

    @After(value = "execution(public int com.utaha.service.Calculator.add(int,int))")
    public void printLogFinallyEnd() {
        log.debug("[AOP后置通知] 方法最终结束了");
    }
*/

    /**
     * 参数@Before 注解标记前置通知方法
     * 参数@annotation(com.utaha.aop.AopInter) 被@AopInter标记的方法才会生效
     * value属性：切入点表达式，告诉Spring当前通知方法要套用到哪个目标方法上
     * 在前置通知方法形参位置声明一个JoinPoint类型的参数，Spring就会将这个对象传入
     * 根据JoinPoint对象就可以获取目标方法名称、实际参数列表
     * @param joinPoint 连接点
     */
    @Before(value = "execution(public int com.utaha.service.Calculator.add(int,int)) " +
            "&& @annotation(com.utaha.aop.AopInter)" + "&& @annotation(aopInter)")
    public void printLogBeforeCore(JoinPoint joinPoint, AopInter aopInter) {

        // 1.通过JoinPoint对象获取目标方法签名对象
        // 方法的签名：一个方法的全部声明信息
        Signature signature = joinPoint.getSignature();

        // 2.通过方法的签名对象获取目标方法的详细信息
        String methodName = signature.getName();
        log.debug("methodName = " + methodName);

        int modifiers = signature.getModifiers();
        log.debug("modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        log.debug("declaringTypeName = " + declaringTypeName);

        // 3.通过JoinPoint对象获取外界调用目标方法时传入的实参列表
        Object[] args = joinPoint.getArgs();

        // 4.由于数组直接打印看不到具体数据，所以转换为List集合
        List<Object> argList = Arrays.asList(args);

        log.debug("还说啥呢，躺一把呗***"+ aopInter.demo());
        log.debug("[AOP前置通知] " + methodName + "方法开始了，参数列表：" + argList);
    }

    /**
     * 参数@AfterReturning 注解标记返回通知方法
     * 在返回通知中获取目标方法返回值分两步：
     * 第一步：在@AfterReturning注解中通过returning属性设置一个名称
     * 第二步：使用returning属性设置的名称在通知方法中声明一个对应的形参
     * @param joinPoint 连接点
     * @param targetMethodReturnValue 目标方法返回值
     */
    @AfterReturning(
            value = "execution(public int com.utaha.service.Calculator.add(int,int))",
            returning = "targetMethodReturnValue"
    )
    public void printLogAfterCoreSuccess(JoinPoint joinPoint, Object targetMethodReturnValue) {

        String methodName = joinPoint.getSignature().getName();

        log.debug("[AOP返回通知] " + methodName + "方法成功结束了，返回值是：" + targetMethodReturnValue);
    }


    /**
     * 参数@AfterThrowing 注解标记异常通知方法
     * 在异常通知中获取目标方法抛出的异常分两步：
     * 第一步：在@AfterThrowing注解中声明一个throwing属性设定形参名称
     * 第二步：使用throwing属性指定的名称在通知方法声明形参，Spring会将目标方法抛出的异常对象从这里传给我们
     * @param joinPoint 连接点
     * @param targetMethodException 目标方法异常
     */
    @AfterThrowing(
            value = "execution(public int com.utaha.service.Calculator.add(int,int))",
            throwing = "targetMethodException"
    )
    public void printLogAfterCoreException(JoinPoint joinPoint, Throwable targetMethodException) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP异常通知] "+methodName+"方法抛异常了，异常类型是：" + targetMethodException.getClass().getName());
    }

    @After(value = "com.utaha.common.UtahaPointCut.utahaGlobalPointCut()")
    public void printLogFinallyEnd() {
        log.debug("[AOP后置通知] 方法最终结束了");
    }
}