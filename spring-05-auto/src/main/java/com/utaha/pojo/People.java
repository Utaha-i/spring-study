package com.utaha.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import javax.annotation.Resource;

public class People {

    /*
        @Autowired由spring提供，是byType注入
        @Qualifier可以通过byName注入
     */
    //(required = false)为空也不会报错
    @Autowired(required = false)
    @Qualifier(value = "cat2")
     private Cat cat;
//    @Resource(name = "dog1")
     private Dog dog;

     private String name;

    public People() {
    }

    //字段标记了这个注解，说明这个字段可以为null
    public People(@Nullable String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }
    @Autowired
    public void setDog(@Qualifier("dog1") Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
