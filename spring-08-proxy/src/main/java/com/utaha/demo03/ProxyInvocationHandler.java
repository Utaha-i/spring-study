package com.utaha.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }
    //    Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
    //            new Class<?>[] { Foo.class },
    //            handler);

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质就是使用反射机制实现！
        seeHouse();
        Object result = method.invoke(rent, args);
        agencyFee();
        contract();
        return result;
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    //收中介费
    public void agencyFee (){
        System.out.println("中介收钱");
    }
    //签合同
    public void contract (){
        System.out.println("签合同");
    }
}
