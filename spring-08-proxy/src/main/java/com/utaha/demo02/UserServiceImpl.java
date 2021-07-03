package com.utaha.demo02;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("使用了add方法");
    }

    @Override
    public void delete() {
        System.out.println("使用了delete方法");
    }

    @Override
    public void update() {
        System.out.println("使用了update方法");
    }

    @Override
    public void select() {
        System.out.println("使用了select方法");
    }
}
