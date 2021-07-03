package com.utaha.pojo;

public class Customer {
    private Integer id;
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
