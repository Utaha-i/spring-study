import com.utaha.dao.UserDaoSqlServiceImpl;
import com.utaha.service.UserService;
import com.utaha.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        /*
        //用户实际调用的是Service层，dao层用户不接触
        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoSqlServiceImpl());

        userService.getUser();

        */
        //获取ApplicationContext：拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
