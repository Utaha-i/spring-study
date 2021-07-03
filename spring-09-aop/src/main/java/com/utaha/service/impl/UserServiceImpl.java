package com.utaha.service.impl;

import com.utaha.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void insert() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新了一个用户");
    }

    @Override
    public void select() {
        System.out.println("查询了一个用户");
    }
}
