import com.utaha.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("auto.xml");
        People people = context.getBean("people", People.class);

        people.getCat().shut();
        people.getDog().shut();
    }
}
