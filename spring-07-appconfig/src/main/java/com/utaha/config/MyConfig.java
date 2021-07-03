package com.utaha.config;

import com.utaha.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//被@Configuration标记的类，也会被容器托管，注册到容器当中，因为他本身也就是一个@Component
@Configuration
//扫描包
@ComponentScan("com.utaha.pojo")
@Import(value = User.class)
public class MyConfig {
    //绿叶子点不了，还需继续研究
    /*
        =<bean>
        注册一个bean，就相当于之前写的一个bean标签
        方法名，就相当于bean标签中的id属性
        方法返回值，相当于class属性

        value
        name
        name 和 value 两个属性是相同的含义的， 在代码中定义了别名。

        autowire
        装配方式 有三个选项
        Autowire.NO (默认设置)
        Autowire.BY_NAME
        Autowire.BY_TYPE
        指定 bean 的装配方式， 根据名称 和 根据类型 装配， 一般不设置，采用默认即可
     */
    @Bean(name = "user2")
    public User user(){
        return new User();
    }
}
