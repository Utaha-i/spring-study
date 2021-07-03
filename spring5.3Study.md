**spring版本为5.3.5 文章的发表时间为2021.7**请注意文章的时效性！！！

有道云笔记链接：
文档：spring.note
链接：http://note.youdao.com/noteshare?id=357c9a3826c95f1c7e2c5f9243e377a3&sub=2DAB7FC83CA84A98A869A6153C90928D

# 1.Spring
## 1.1简介

 - 春天------>给软件行业带来了春天！
 - 2002，interface 21，Spring框架的雏形
 - Spring框架即以interface21框架为基础,经过重新设计;并不断丰富其内涵,于2004年3月24日,发布了1.0正式版。
 - Rod Johnson 悉尼大学的音乐，计算机双学位

- Spring理念：使现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架。
*i18n（其来源是英文单词 internationalization的首末字符i和n，18为中间的字符数）是“国际化”的简称。*
- SSH：Struct2 + Spring +Hibernate
- SSM：SpringMVC + Spring +Mybatis
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.5</version>
</dependency>
```
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.5</version>
</dependency>
```


## 1.2优点

- Spring是一个开源的免费的框架（容器）
- Spring是一个轻量级、非入侵式的框架
- 控制反转（IOC）、面向切面编程（AOP）
- 支持事务的处理，对框架整合的支持

***总结一句话:：Spring就是一个轻量级的控制反转（IOC)和面向切面编程的框架！***

## 1.3组成
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701205111910.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

## 1.4拓展

现代化的java开发
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701205308424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

**Spring Boot**
- 一个快速开发的脚手架。
- 基于SpringBoot可以快速的开发单个微服务，约定大于配置!
- Spring Cloud
- SpringCloud是基于SpringBoot实现的。
因为现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提，需要完全掌握Spring及SpringMVC!
*弊端：发展了太久，违背了原来的理念！配置十分繁琐，人称“配置地狱”。*

--------------------------------------------------------------------------------
# **2.IOC理论推导**

 1. UserDao 接口
 2. UserDaoImpl 实现类
 3. UserService 业务接口
 4. UserServiceImpl 业务实现类

在我们之前的业务中，用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改原代码！如果程序代码量十分大，修改一次的成本价十分昂贵！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701205605829.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
我们使用一个set接口实现

```java
private UserDao userDao ;
//利用set进行动态实现值的注入！
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
}
```

 - 之前，程序是主动创建对象！控制权在程序猿手上！
 - 使用set注入后，程序不再具有主动性，而是被动的接受对象！

 这种思想，从本质上解决了问题，我们程序员不用自己去管理对象了。系统的耦合性大大降低，可以更加专注的在业务的实现上。这是IOC的原型！

**IOC本质**

控制反转lOC(Inversion of Control)。是一种设计思想，**DI(依赖注入)**是实现lOC的一种方法，也有人认为DI只是lOC的另一种说法。没有lOC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是:获得依赖对象的方式反转了。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701205850146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
**loC是Spring框架的核心内容**，使用多种方式完美的实现了loC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现loC。
Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从loc容器中取出需要的对象。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701205931281.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为—体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。
控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是loC容器，其实现方法是依赖注入(Dependency Injection,Dl)。

--------------------------------------------------------------------------------
# 3.Hello Spring

```xml
<!--使用Spring来创建对象，在Spring这些都称为Bean
    类型 变量名 = new 类型();
    bean = 对象  new Hello();
    id -> 变量名
    class -> new 的对象
    property 相当于给对象的属性设置 set 一个值
-->
<bean id="hello" class="com.utaha.pojo.Hello">
    <property name="name" value="Spring"/>
</bean>
```

**这个过程就叫控制反转：**
控制：谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的。
反转：程序本身不创建对象，而变成被动的接收对象。
依赖注入：就是利用set方法来进行注入的。
IOC是一种编程思想，由主动的编程变成被动的接收。
可以通过new ClassPathXmIApplicationContext去浏览一下底层源码。
***OK，到了现在，我们彻底不用再程序中去改动了，要实现不同的操作，只需要在xml配置文件中进行修改。
所谓的loC,一句话搞定：对象由Spring来创建，管理，装配!***

```java
<!--
ref 引用spring容器中已经创建好的对象     （引用类型）
value 具体类型的值                    （基本类型）
-->
```

--------------------------------------------------------------------------------
# 4.IOC创建对象的方式

1.使用无参构造创建对象，默认！
2.假设我们要使用有参构造创建对象。

```xml
<!--使用无参构造器赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <property name="name" value="zhangsan"/>
    </bean>
```

```xml
<!--第一种下标赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <constructor-arg index="0" value="lisi"/>
    </bean>
```

```xml
<!--第二种通过创建类型（不建议使用）-->
    <bean id="user" class="com.utaha.pojo.User">
        <constructor-arg type="java.lang.String" value="wangwu"/>
    </bean>
```

```xml
<!--第三种通过参数名来赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <constructor-arg name="name" value="zhaoliu"/>
    </bean>
```


**总结：在配置文件加载的时候，容器中管理的对象就已经初始化了!**

--------------------------------------------------------------------------------
# 5.Spring的配置

## 5.1 别名

```xml
<!--别名，如果添加了别名，我们也可以通关别名-->
    <alias name="user" alias="utaha" />
```


## 5.2 bean的配置

```xml
<!--
id : bean 的唯一标识符，也就是我们学的对象名
class : bean 对象所对应的全限定名
name : 也是别名，而且 name 更高级，可以同时取多个别名
-->
<bean id="userT" class="com.utaha.pojo.UserT" name="userT2,u2 u3;u4"/>
```

## 5.3 import

一般用于团队开发，可以使得多个配置文件导入合并为一个。
假设项目中有多个人开发，负责不同的类，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个，使用的时候使用总的就可以了。

```xml
<import resource="beans.xml" />
```


--------------------------------------------------------------------------------
# 6.DI依赖注入

## 6.1 构造器注入

```xml
<!--使用无参构造器赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <property name="name" value="zhangsan"/>
    </bean>-->
<!--第一种下标赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <constructor-arg index="0" value="lisi"/>
    </bean>-->
<!--第二种通过创建类型（不建议使用）-->
    <bean id="user" class="com.utaha.pojo.User">
       <constructor-arg type="java.lang.String" value="wangwu"/>
    </bean>-->
<!--第三种通过参数名来赋值-->
    <bean id="user" class="com.utaha.pojo.User">
        <constructor-arg name="name" value="zhaoliu"/>
    </bean>
```

## 6.2 set方式注入（重点）

依赖		bean对象的创建依赖容器
注入		bean对象中的所有属性，由容器来注入 

```xml
<bean id="address" class="com.utaha.pojo.Address">
    <property name="address" value="寿阳"/>
</bean>
<bean id="student" class="com.utaha.pojo.Student">
<!--第一种普通值注入-->
    <property name="name" value="霞诗子"/>
<!--ref引用类型注入-->
    <property name="address" ref="address"/>
<!--数组-->
    <property name="books">
        <array>
            <value>D.A.L</value>
            <value>overlord</value>
            <value>DXD</value>
        </array>
    </property>
<!--list-->
    <property name="hobbies">
        <list>
            <value>A</value>
            <value>C</value>
            <value>G</value>
            <value>N</value>
        </list>
    </property>
<!--Map-->
    <property name="card">
        <map>
            <entry key="IDCard" value="123456"/>
            <entry key="Bank" value="45678"/>
        </map>
    </property>
<!--Set-->
    <property name="games">
        <set>
            <value>Dota</value>
            <value>Azurlane</value>
            <value>fgo</value>
            <value>WOW</value>
        </set>
    </property>
<!--Null-->
    <property name="wife">
        <null/>
    </property>
<!--properties-->
    <property name="info">
        <props>
            <prop key="学号">20210426</prop>
            <prop key="性别">boy</prop>
            <prop key="班级">2.2</prop>
        </props>
    </property>
</bean>
```

## 6.3 拓展方式注入

c命名空间，p命名空间

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701210557401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```

```xml
<!--p命名空间注入，可以直接注入属性的值（properties）-->
    <bean id="user" class="com.utaha.pojo.User" p:name="utaha" p:age="17"/>
```

```xml
<!--c命名空间,通关构造器注入（constructor）-->
    <bean id="user2" class="com.utaha.pojo.User" c:age="17" c:name="utaha"/>
```

注意点：
P命名空间和C命名空间不能直接使用，需要导入XML约束。

## 6.4 bean的作用域
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701210649926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701210702204.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
单例模式（默认）

```xml
<bean id="user" class="com.utaha.pojo.User" p:name="utaha" p:age="17" scope="singleton"/>
```

原型模式

```xml
<bean id="accountService" class="com.foo.DefaultAccountService" scope="prototype"/>
```

其余的在web开发才会使用

--------------------------------------------------------------------------------
# 7.bean的自动装配

 - 自动装配是Spring满足bean依赖的一种方式
 - Spring会在上下文中自动寻找，并自动给bean装配属性。

**在Spring中有3种自动装配的方式：**
 1. 在xml中显示的配置
 2. 在java中显示的配置
 3. 隐式的自动装配【重点】

## 7.1 测试

环境搭建
一个人有两个宠物！

## 7.2 自动装配

byName

```xml
<!--
    byName: 会自动在容器上下文中查找，和自己对象set方法后面对应的 bean_id
-->
<bean id="people" class="com.utaha.pojo.People" autowire="byName">
    <property name="name" value="霞诗子"/>
</bean>
```

byType

```xml
<!--
    byType: 会自动在容器上下文中查找，和自己对象属性类型相同的bean_id
    （必须保证该类型全局唯一，不然bean标签，直接报错）
-->
<bean id="people" class="com.utaha.pojo.People" autowire="byType">
    <property name="name" value="霞诗子"/>
</bean>
```

## 7.3 小结

 - 在byName的时候，要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致。
 - 在byType的时候，要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致。

## 7.4 使用注解进行自动装配

jdk1.5 spring2.5支持注解
要使用注解需要：

 1. 导入约束 	context约束
 2. 配置注解的支持		context:annotation-config 【重要】

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```


**@Autowired**
直接在属性上使用（可以去掉set方法，直接依靠反射）
（也可以在set方法上）

**@Nullable**
@Nullable 字段标记了这个注解，说明这个字段可以为null

@Autowired由spring提供，byType、byName都找一遍
**@Qualifier**
@Qualifier可以通过byName注入
//(required = false)为空也不会报错
**@Autowired**(required = false)
**@Qualifier**(value = "cat222")

如果@Autowired自动装配的环境比较复杂时候，自动装配无法通过一个【@Autowired】完成时候，我们可以使用@Qualifier(value=" xxx")去配合@Autowried共同使用，指定唯一的一个bean对象注入。
**@Resource**
@Resource(name="xxx")

@Resource和@Autowired的区别



```java
@Autowired按类型装配依赖对象，默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它required属性为false。
如果查询的结果不止一个，那么@Autowired会根据名称来查找。
如果我们想使用按名称装配，也可以结合@Qualifier注解一起使用。
```


```java
@Resource有两个中重要的属性：name和type。name属性指定byName，
如果没有指定name属性，当注解标注在字段上，即默认取字段的名称作为bean名称寻找依赖对象，
当注解标注在属性的setter方法上，即默认取属性名作为bean名称寻找依赖对象。
需要注意的是，@Resource如果没有指定name属性，并且按照默认的名称仍然找不到依赖对象时， 
@Resource注解会回退到按类型装配。但一旦指定了name属性，就只能按名称装配了。
```

***@Resource装配顺序***
- 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
- 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
- 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
- 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配

最后推荐使用@Resource注解在字段上，这样就不用写setter方法了。
并且这个注解是属于J2EE的，减少了与Spring的耦合,这样代码看起就比较优雅 。

--------------------------------------------------------------------------------
# 8.使用注解开发

## 8.1 bean

使用注解必须导入aop的包
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701211423196.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

使用注解需要导入context约束，增加注解的支持。

## 8.2 属性如何注入

```java
/*   
    Component：组件
    等价与<bean id="user" class="com.utaha.pojo.User"/>
 */
@Component
public class User {
    /*
        等价于<property name="name" value="霞诗子"/>
        也可以放在set方法上
     */
    @Value("霞诗子")
    public String name;
}
```

## 8.3 衍生的注解

**@Component**的衍生 在web开发中，使用mvc三层架构分层

 - dao----------*@Repository*
 - service------*@Service*
 - controller---*@Controller*

这四个注解功能都是一样的，都是代表某个类注册到Spring容器中，装配Bean。

## 8.4 自动装配

```java
@Autowired 自动装配 先type后name
@Qualifier(value="xxx")按name装配
@Nullable 字段标记了这个注解，说明这个字段可以为null
@Resource(name="xxx") 自动装配 先name后type
```

## 8.5 作用域

**@Scope**("singleton","prototype","request","session").

## 8.6 小结

XML与注解

 - XML更加万能适用于任何场景，维护简单方便。
 - 注解不是自己当前类使用不了，维护相对复杂！

最佳实现

 - XML用来管理Bean；
 - 注解只负责属性的注入。

--------------------------------------------------------------------------------

# 9.使用java方式配置

完全不使用xml配置文件。
javaConfig
java配置类等价于XML
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701211719875.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701211742894.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)




```java
//被@Configuration标记的类，也会被容器托管，注册到容器当中，因为他本身也就是一个@Component
@Configuration
//扫描包
@ComponentScan("com.utaha.pojo")
```

@Bean默认是单例模式，并且没有提供指定作用域的属性，可以通过

```java
@Scope来实现该功能。
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
```

这种纯java的配置方式，在springboot中随处可见。

--------------------------------------------------------------------------------
# 10.代理模式

为springAop的底层
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701211837304.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

代理模式分类

 - 静态代理
 - 动态代理

## 10.1 静态代理

角色分析:

 - 抽象角色：一般会使用接口或者抽象类来解决
 - 真实角色：被代理的角色
 - 代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
 - 客户：访问代理对象的人

代码步骤：

 1. 接口
 2. 真实角色
 3. 代理角色
 4. 客户端访问代理角色

代理模式的好处：

 - 可以使可以使真实角色的操作更加纯粹！不用去关注一些公告的业务。
 - 公共业务就交给了代理角色。实现了业务的分工。
 - 公共业务发生扩展的时候，方便集中管理。

缺点：
一个真实角色就会产生一个代理角色；代码量会翻倍。开发效率会变低

## 10.2 加深理解

![代码对应08-Demo02](https://img-blog.csdnimg.cn/20210701211938359.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)


## 10.3 动态代理

 - 动态代理和静态代理一样
 - 动态代理的类是动态生成的，不是我们直接写好的
 - 动态代理分为两大类：基于接口的动态代理，基于类的动态代理



 1. 基于接口	JDK的动态代理
 2. 基于类的	cglib
 3. java字节码实现	javassist

需要了解两个类，Proxy、Invocationhandler(调用处理工具)

***Invocationhandler***
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021070121210437.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)


动态代理的好处：

 - 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务
 - 公共也就就交给代理角色!实现了业务的分工
 - 公共业务发生扩展的时候，方便集中管理
 - 一个动态代理类代理的是一个接口，一般就是对应的一类业务
 - —个动态代理类可以代理多个类，只要是实现了同一个接白即可

--------------------------------------------------------------------------------

# 11.AOP

## 11.1 什么是aop

AOP(Aspect Oriented Programming)意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212152720.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

## 11.2 Aop在Spring中的作用

**提供声明式事务；分许用户自定义切面**
横切关注点：跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。如日志,安全，缓存，事务等等....
**切面(ASPECT)**：横切关注点被模块化的特殊对象。即，它是一个类。
**通知(Advice)**：切面必须要完成的工作。即，它是类中的一个方法。
**目标(Target)**：被通知对象。
**代理(Proxy)**：向目标对象应用通知之后创建的对象。
**切入点(PointCut)**：切面通知执行的“地点"的定义。
**连接点(JointPoint)** ：与切入点匹配的执行点。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212234913.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212245466.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)



## 11.3 使用spring的实现AOP

【重点】导入AOP织入包

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.5</version>
</dependency>
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212313268.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)


方式一：使用Spring的API接口【主要是SpringAPI接口实现】

```xml
<!--配置aop：需要导入aop约束-->
    <!--方式一：使用原生的Spring API 接口-->
    <aop:config>
        <!--切入点：expression：表达式 execution（要执行的位置 * * * * *）-->
        <aop:pointcut id="pointcut" expression="execution(* com.utaha.service.impl.UserServiceImpl.*(..))"/>
        <!--执行环绕增加-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut" />
    </aop:config>
```

方式二：自定义类来实现AOP【主要是切面定义】

```xml
<bean id="diy" class="com.utaha.diy.DiyPointCut"/>
<aop:config>
    <!--自定义切面 ref为自定义的类-->
    <aop:aspect ref="diy">
        <!--配置切入点-->
        <aop:pointcut id="pointcut" expression="execution(* com.utaha.service.impl.UserServiceImpl.*(..))"/>
        <!--配置通知-->
        <aop:before method="before" pointcut-ref="pointcut"/>
        <aop:after method="after" pointcut-ref="pointcut"/>
    </aop:aspect>
</aop:config>
```

方式三：使用注解实现AOP

```xml
<!--方式三：使用注解实现AOP-->
<!--开启注解支持-->
<context:annotation-config/>
<!--指定扫描包，这个包下的注解就会生效-->
<context:component-scan base-package="com.utaha"/>
<!--开启注解支持 JDK动态代理为默认false  cgLib为true-->
<aop:aspectj-autoproxy proxy-target-class="false"/>
```

```java
@Component
@Aspect
public class AnnotationPointCut {
    //配置PointCut
    @Pointcut("execution(* com.utaha.service.impl.UserServiceImpl.*(..))")
    public void pointCut() {}
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("注解实现*********前********");
    }
    @After(value = "pointCut()")
    public void after() {
        System.out.println("注解实现*********后********");
    }
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        jp.proceed();//执行方法
        Signature signature = jp.getSignature();//获得签名
        System.out.println("signature:" + signature);
        System.out.println("环绕后");
    }
}
```

***AOP有两个概念（切面，通知） OOP有两个概念（target，proxy） 连接的桥梁为（切入点和连接点）***

--------------------------------------------------------------------------------

# 12.整合Mybatis

步骤：
1.导入相关jar包

 - junit

- mybatis
- mysql
- spring
- aop织入
- mybatis-spring

2.编写配置文件
3.测试

## 12.1 回顾Mybatis

- 编写实体类
- 编写核心配置文件
- 编写接口
- 编写Mapper.xml
- 测试

## 12.2 Mybatis-spring

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--datasource：使用Spring的数据源替换Mybatis的配置 c3p0 dbcp druid
    我们这里使用Spring提供的JDBC-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/estore?characterEncoding=utf-8&amp;serverTimezone=UTC&amp;useSSL=true"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>
    <!--sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!--绑定Mybatis配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:com/utaha/mapper/*.xml"/>
    </bean>
    <!--sqlSessionTemplate：就是我们使用的sqlSession-->
    <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
        <!--只能使用构造器注入，因为源码没有使用set方法-->
        <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"/>
    </bean>
</beans>
```

 1. 编写数据源配置
 2. sqlSessionFactory
 3. sqlSessionTemplate
 4. 需要给接口加实现类
 5. 将自己写的实现类，注入到spring中
 6. 测试使用
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212513473.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)

是有4层，Impl中想要调用sqlSessionTemplate方法去实现增删改查，MapperImpl 注入bean中 ----->需要ref(sqlSessionTemplate)------->注入sqlSessionTemplate后仍需要ref(sqlSessionFactory)---------->注入sqlSessionFactory同理需要ref(dataSource)--------->注入dataSource

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212525492.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)


方式二  简化一步  不需要 sqlSessionTemplate
继承SqlSessionDaoSupport 父类 少注入一步，其他同理

--------------------------------------------------------------------------------

# 13.声明式事务

## 13.1.回顾事务

 1. 要么都成功，要么都失败！
 2. 在项目开发中，十分重要，设计到数据的一致性问题，不能马虎
 3. 确保完整性和一致性

事务的ACID原则：

 - 原子性
 - 一致性
 - 隔离性

	多个业务可能操作同一个资源，防止数据损坏

 - 持久性

	事务一旦提交，五轮系统发生什么问题，结果都不会被再影响，被持久化的写到存储器中

## 13.2. Spring中的事务管理

- 声明式事务：Aop
- 编程式事务：需要在代码中管理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701212650237.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1V0YWhhXw==,size_16,color_FFFFFF,t_70)


为什么需要事务？
- 如果不配置事务，可能存在数据提交不一致的情况下；
- 如果我们不在SPRING中去配置声明式事务，我们就需要在代码中手动配置事务
- 事务在项目的开发中十分重要，设计到数据的一致性和完整性问题，不容马虎





