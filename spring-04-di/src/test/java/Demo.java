import com.utaha.pojo.Student;
import com.utaha.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        /*
        Student{
        name='霞诗子',
        address=Address{address='寿阳'},
        books=[D.A.L, overlord, DXD],
        hobbies=[A, C, G, N],
        card={
            IDCard=123456,
            Bank=45678
            },
        games=[Dota, Azurlane, fgo, WOW],
        info={
            班级=2.2,
            学号=20210426,
            性别=boy
            },
        wife='null'
        }
         */
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
