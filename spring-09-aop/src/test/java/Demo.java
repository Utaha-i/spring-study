import com.utaha.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //代理的为接口，不是impl实现类
        UserService userService = (UserService) context.getBean("userService");
        userService.update();
    }
}
