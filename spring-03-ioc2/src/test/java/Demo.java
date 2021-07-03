import com.utaha.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {

        //Spring容器类似于婚介网站，想取谁就get就好了
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        User utaha = (User) context.getBean("utaha");
        //true  内存中只有一份user对象
        System.out.println(user == user2);
        user.show();
        utaha.show();
    }
}
