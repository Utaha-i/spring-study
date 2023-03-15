package com.utaha.demo05.proxy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

@Slf4j
// 泛型T要求是目标对象实现的接口类型，本代理类根据这个接口来进行代理
public class LogDynamicProxyFactory<T> {

    // 将被代理的目标对象声明为成员变量
    private T target;

    public LogDynamicProxyFactory(T target) {
        this.target = target;
    }

    public T getProxy() {

        // 创建代理对象所需参数一：加载目标对象的类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 创建代理对象所需参数二：目标对象的类所实现的所有接口组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // 创建代理对象所需参数三：InvocationHandler对象
        // Lambda表达式口诀：
        // 1、复制小括号
        // 2、写死右箭头
        // 3、落地大括号
        InvocationHandler handler = (
                // 代理对象，当前方法用不上这个对象
                Object proxy,

                // method就是代表目标方法的Method对象
                Method method,

                // 外部调用目标方法时传入的实际参数
                Object[] args) -> {

            // 我们对InvocationHandler接口中invoke()方法的实现就是在调用目标方法
            // 围绕目标方法的调用，就可以添加我们的附加功能

            // 声明一个局部变量，用来存储目标方法的返回值
            Object targetMethodReturnValue = null;

            // 通过method对象获取方法名
            String methodName = method.getName();

            // 为了便于在打印时看到数组中的数据，把参数数组转换为List
            List<Object> argumentList = Arrays.asList(args);
//TODO java代理对象java.nullPointerException异常,无法评估com.sun.proxy.toString
            try {

                // 在目标方法执行前：打印方法开始的日志
                log.debug("[动态代理][日志] " + methodName + " 方法开始了，参数是：" + argumentList);

                // 调用目标方法：需要传入两个参数
                // 参数1：调用目标方法的目标对象
                // 参数2：外部调用目标方法时传入的实际参数
                // 调用后会返回目标方法的返回值
                targetMethodReturnValue = method.invoke(target, args);

                // 在目标方法成功后：打印方法成功结束的日志【寿终正寝】
                log.debug("[动态代理][日志] " + methodName + " 方法成功结束了，返回值是：" + targetMethodReturnValue);

            } catch (Exception e) {

                // 通过e对象获取异常类型的全类名
                String exceptionName = e.getClass().getName();

                // 通过e对象获取异常消息
                String message = e.getMessage();

                // 在目标方法失败后：打印方法抛出异常的日志【死于非命】
                log.debug("[动态代理][日志] " + methodName + " 方法抛异常了，异常信息是：" + exceptionName + "," + message);

            } finally {

                // 在目标方法最终结束后：打印方法最终结束的日志【盖棺定论】
                log.debug("[动态代理][日志] " + methodName + " 方法最终结束了");

            }

            // 这里必须将目标方法的返回值返回给外界，如果没有返回，外界将无法拿到目标方法的返回值
            return targetMethodReturnValue;
        };

        // 创建代理对象
        T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);

        // 返回代理对象
        return proxy;
    }
}