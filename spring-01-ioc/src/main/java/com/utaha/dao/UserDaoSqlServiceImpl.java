package com.utaha.dao;

public class UserDaoSqlServiceImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("SqlServer获取用户对象");
    }
}
