package com.utaha.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
    Component：组件
    等价与<bean id="user" class="com.utaha.pojo.User"/>
 */
@Component
@Scope("session")
public class User {
    /*
        等价于<property name="name" value="霞诗子"/>
        也可以放在set方法上
     */
    @Value("霞诗子")
    public String name;
}
