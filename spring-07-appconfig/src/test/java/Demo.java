import com.utaha.config.MyConfig;
import com.utaha.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user2");
        String[] beanNamesForType = context.getBeanNamesForType(User.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
//        System.out.println(user == user2);
//        System.out.println(user);
//        System.out.println(user2);
    }
    @Test
    public void printBeans() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        //获取容器中所有的bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
