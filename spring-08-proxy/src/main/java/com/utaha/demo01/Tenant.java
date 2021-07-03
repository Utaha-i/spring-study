package com.utaha.demo01;

//租客
public class Tenant {
    public static void main(String[] args) {
        //直接找房东租房
        Landlord landlord = new Landlord();
        landlord.rent();
        System.out.println("--------------");
        //通过代理租房，代理通常会有 一些附属操作。
        Proxy proxy = new Proxy(landlord);
        //不用面对房东，直接找中介
        proxy.rent();
    }
}
