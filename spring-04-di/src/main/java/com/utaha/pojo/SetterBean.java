package com.utaha.pojo;

import java.util.List;

public class SetterBean {

    private IService service;

    public interface IService {} //@1

    public static class ServiceA implements IService {} //@2
    public static class ServiceB implements IService {} //@3

    public void setService(IService service) {
        this.service = service;
    }
    public void setService1(List<IService> service) {//@0
        System.out.println(service); //@1
    }

    @Override
    public String toString() {
        return "SetterBean{" +
                "service=" + service +
                '}';
    }
}
